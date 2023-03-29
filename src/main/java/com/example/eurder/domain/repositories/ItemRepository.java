package com.example.eurder.domain.repositories;

import com.example.eurder.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ItemRepository {

    private final ArrayList<Item> items = new ArrayList<>();

    public Item addNewType(Item item) {
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
}
