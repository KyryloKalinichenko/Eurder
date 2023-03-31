package com.example.eurder.domain.repositories;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.Item;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private final ArrayList<Item> items = new ArrayList<>();

    public Item addNewType(Item item) {
        if (! isItemUnique(item)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The item already exist!");
        }
        items.add(item);
        return item;
    }

    public Item getItemById(int id) throws RuntimeException {
        return items.stream().filter(x -> x.getId() == id).findFirst().orElseThrow();
    }

    public void decriesStock(int itemId, int amount) {
        Item item = getItemById(itemId);
        item.decriesStock(amount);
        items.set(items.indexOf(item), item);
    }

    public List<Item> getAllItems(){
        return items;
    }

    private boolean isItemUnique(Item toCheck){
        return !items.contains(toCheck);
    }
}
