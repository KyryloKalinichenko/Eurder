package com.example.eurder.api.order;

import com.example.eurder.api.item.ItemGroupPostDTO;
import com.example.eurder.domain.item.ItemGroup;

import java.util.List;

public class OrderPostDTO {

    private List<ItemGroupPostDTO> itemGroups;

    public OrderPostDTO(List<ItemGroupPostDTO> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public OrderPostDTO() {
    }

    public List<ItemGroupPostDTO> getItemGroups() {
        return itemGroups;
    }

}
