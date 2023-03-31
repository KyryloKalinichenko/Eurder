package com.example.eurder.service;

import com.example.eurder.api.item.ItemGetDTO;
import com.example.eurder.api.item.ItemPostDTO;
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

    public ItemGetDTO addItem(ItemPostDTO item, String token) {
        tokenVerification(token);
        return new ItemGetDTO(repository.addNewType(new Item(item)));
    }

    private static void tokenVerification(String token) {
        if (token == null || !token.equals("admin")){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied!");
        }
    }
}
