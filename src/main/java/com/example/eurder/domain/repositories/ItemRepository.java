package com.example.eurder.domain.repositories;

import com.example.eurder.domain.item.Item;

import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items = new ArrayList<>();

    public Item addNewType(Item item){
        items.add(item);
        return item;
    }
}
