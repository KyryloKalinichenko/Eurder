package com.example.eurder.api.order;

import com.example.eurder.api.item.ItemGroupPostDTO;
import com.example.eurder.domain.item.ItemGroup;

import java.util.List;

public class OrderPostDTO {

    private List<ItemGroupPostDTO> itemGroups;
    private int CustomerId;

    public OrderPostDTO(List<ItemGroupPostDTO> itemGroups, int customerId) {
        this.itemGroups = itemGroups;
        CustomerId = customerId;
    }

    public List<ItemGroupPostDTO> getItemGroups() {
        return itemGroups;
    }

    public int getCustomerId() {
        return CustomerId;
    }
}
