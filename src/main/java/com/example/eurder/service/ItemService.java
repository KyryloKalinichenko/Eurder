package com.example.eurder.service;

import com.example.eurder.api.item.ItemDTO;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.repositories.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public ItemDTO addItem(Item item, String token) {
        if (token == null || !token.equals("admin")){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied!");
        }
        return new ItemDTO(repository.addNewType(item));
    }
}
