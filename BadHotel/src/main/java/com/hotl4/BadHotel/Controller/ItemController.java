package com.hotl4.BadHotel.Controller;

import com.hotl4.BadHotel.Model.Item;
import com.hotl4.BadHotel.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Mono<ResponseEntity<Item>> createItem(@RequestBody Item item) {
        return itemService.createItem(item)
                .map(savedItem -> ResponseEntity.status(HttpStatus.CREATED).body(savedItem));
    }
}
