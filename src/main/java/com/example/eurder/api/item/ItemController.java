package com.example.eurder.api.item;

import com.example.eurder.domain.item.Item;
import com.example.eurder.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody Item item, @RequestHeader String token){
        return service.addItem(item, token);
    }
}
