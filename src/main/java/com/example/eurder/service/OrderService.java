package com.example.eurder.service;

import com.example.eurder.api.item.ItemGroupPostDTO;
import com.example.eurder.api.order.OrderGetDTO;
import com.example.eurder.api.order.OrderPostDTO;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemGroup;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.repositories.CustomerRepository;
import com.example.eurder.domain.repositories.ItemRepository;
import com.example.eurder.domain.repositories.OrderRepository;
import com.example.eurder.service.mappers.OrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public static final int DELAY_WHEN_OUT_OF_STOCK = 7;
    public static final int NORMAL_DELAY = 1;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    public OrderGetDTO submitNewOrder(OrderPostDTO postDTO, int customerId){

        validateInput(postDTO, customerId);

        Customer owner = getCustomerById(customerId);
        ArrayList<ItemGroup> itemGroups = getItemGroupsFromPostDTO(postDTO.getItemGroups());

        Order order = orderRepository.addNewOrder(
                new Order(itemGroups, owner, getTotalFromListOfItemGroups(itemGroups)));

        return OrderMapper.fromOrderToGetDTO(order);
    }

    private static Double getTotalFromListOfItemGroups(ArrayList<ItemGroup> itemGroups) {
        return itemGroups.stream().reduce(0.0, (total, current) -> total + current.getTotal(), Double::sum);
    }

    private ArrayList<ItemGroup> getItemGroupsFromPostDTO(List<ItemGroupPostDTO> itemGroupPostDTOs) {

        ArrayList<ItemGroup> result = new ArrayList<>();
        for (ItemGroupPostDTO postDTO: itemGroupPostDTOs) {
            Item currentItem = getItemById(postDTO);
            LocalDate shippingDay = calculateShippingDateForAnItemGroup(postDTO);

            itemRepository.decriesStock(postDTO.getItemId(), postDTO.getAmount());

            result.add(new ItemGroup(currentItem, postDTO.getAmount(), shippingDay));
        }
        return result;
    }

    private Item getItemById(ItemGroupPostDTO postDTO) {
        Item currentItem;
        try {
            currentItem = itemRepository.getItemById(postDTO.getItemId());

        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found!");
        }
        return currentItem;
    }

    private Customer getCustomerById(int id) {
        Customer owner;
        try {
            owner = customerRepository.getCustomerById(id);
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with this id.");
        }
        return owner;
    }

    private void validateInput(OrderPostDTO postDTO, int customerId) {
        if (postDTO.getItemGroups() == null || customerId < 0)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not all fields were filled or input is not acceptable.");
        }
    }



    private LocalDate calculateShippingDateForAnItemGroup(ItemGroupPostDTO postDTO) {
        if (itemRepository.getItemById(postDTO.getItemId()).getAmount() < postDTO.getAmount()){
            return LocalDate.now().plusDays(DELAY_WHEN_OUT_OF_STOCK);
        }
        return LocalDate.now().plusDays(NORMAL_DELAY);
    }
}
