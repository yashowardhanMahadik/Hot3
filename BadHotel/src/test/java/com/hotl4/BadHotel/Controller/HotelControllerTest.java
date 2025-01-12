package com.hotl4.BadHotel.Controller;

import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Service.HotelService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(HotelController.class)
class HotelControllerTest {
    static Hotel hot1;
    @BeforeAll
    public static void beforeAll(){
        hot1 = new Hotel();
        hot1.setHotelId("1");
        hot1.setHotelName("Hehehe");
        hot1.setHotelAddress("1st street, china town");
        hot1.setCity("Oslo");
    }


    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private HotelService hotelService;

    @Test
    void addHotel() {

        when(hotelService.addHotel(any(Hotel.class)))
                .thenReturn(Mono.just(hot1));
        webTestClient.post()
                .uri("/addHotel")
                .bodyValue(hot1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.hotelId").isEqualTo("1")
                .jsonPath("$.hotelName").isEqualTo("Hehehe")
                .jsonPath("$.hotelAddress").isEqualTo("1st street, china town")
                .jsonPath("$.city").isEqualTo("Oslo");;

    }

    @Test
    void getHotels() {
        webTestClient.get()
                .uri("/getAll")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void getHotel2() {
//        when(hotelService.getByName(anyString()))
//                .thenReturn(Mono.just(ResponseEntity.ok(hot1)));
//        webTestClient.get()
//                .uri("/getOne")
//                .exchange()
//                .expectStatus().isOk();
    }
}