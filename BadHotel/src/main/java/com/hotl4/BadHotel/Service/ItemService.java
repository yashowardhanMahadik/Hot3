package com.hotl4.BadHotel.Service;

import com.hotl4.BadHotel.Model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ItemService {

    public Mono<Item> createItem(Item item) {
        // Simulate item creation
        return Mono.just(new Item(item.getId(), item.getName(), item.getPrice()));
    }
}