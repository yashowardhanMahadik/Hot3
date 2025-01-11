package com.hotl4.BadHotel.Controller;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HotelController {
    private final HotelService hotelService;

    //Router operations documentation later
    // API endpoint to add a new hotel

    /*
    todo: add DTO instead of Hotel class
    todo :add ServerResponse instead of the Hotel class
    todo: add common Exception handler as well

     */
    @PostMapping("/addHotel")
    public Mono<Hotel>  addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PostMapping("/addHotel2")
    public Mono<ServerResponse> addHotel2(@RequestBody HotelDTO hotel){
        return hotelService.addHotel2(hotel);
    }
}
