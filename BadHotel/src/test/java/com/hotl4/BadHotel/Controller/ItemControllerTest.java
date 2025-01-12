package com.hotl4.BadHotel.Controller;

import com.hotl4.BadHotel.Model.Item;
import com.hotl4.BadHotel.Service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ItemService itemService;

    @Test
    void testCreateItem() {
        // Mock the service layer
        Item item = new Item("1", "Test Item", 9.99);
        when(itemService.createItem(any(Item.class))).thenReturn(Mono.just(item));

        // Test the POST endpoint
        webTestClient.post()
                .uri("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new Item(null, "Test Item", 9.99))
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.name").isEqualTo("Test Item")
                .jsonPath("$.price").isEqualTo(9.99);
    }
}