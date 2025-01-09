package com.hot3.HotelServiceApp.router;

import com.hot3.HotelServiceApp.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/hot3")
@RequiredArgsConstructor
public class HotelController {

    private final HotelHandler hotelHandler;

    @PostMapping("/addNew")
    public Mono<ServerResponse> addHotel(@Valid @RequestBody Hotel hotel){
        return hotelHandler.addHotel(hotel);
    }
}
