package com.hot3.HotelServiceApp.router;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.service.HotelService;
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
    private final HotelService hotelService;

    @PostMapping("/addNew")
    public Mono<ServerResponse> addHotel(@RequestBody Hotel hotel){

        System.out.println("Hptel Controller call : "+hotel.toString());
        Mono<Hotel> hotelMono = hotelService.addHotel(hotel);
        return ServerResponse.ok().bodyValue(hotelMono);
//        return hotelHandler.addHotel(hotel);
    }
}
