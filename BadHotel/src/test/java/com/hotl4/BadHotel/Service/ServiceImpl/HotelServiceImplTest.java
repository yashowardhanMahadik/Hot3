package com.hotl4.BadHotel.Service.ServiceImpl;

import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Repository.HotelRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceImplTest {
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
    private HotelServiceImpl hotelService;

    @MockBean
    private HotelRepository repo;


    @Test
    void addHotel() {
        when(repo.save(hot1)).thenReturn(Mono.just(hot1));
        Mono<Hotel> hotelMono = hotelService.addHotel(hot1);
        StepVerifier.create(hotelMono)
                .expectNext(hot1)
                .verifyComplete();
    }

    @Test
    void getAllHotels() {
        when(repo.findAll()).thenReturn(Flux.just(hot1,hot1));
        ResponseEntity<Flux<Hotel>> allHotels = hotelService.getAllHotels();
        Flux<Hotel> body = allHotels.getBody();
        Objects.requireNonNull(body);
        StepVerifier.create(body)
                .expectNext(hot1,hot1)
                .verifyComplete();

    }
}