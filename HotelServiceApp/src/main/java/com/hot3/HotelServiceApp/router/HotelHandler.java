package com.hot3.HotelServiceApp.router;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HotelHandler {
    @Autowired
    private HotelService hotelService;

    public Mono<ServerResponse> getAllHotels(ServerRequest serverRequest){
        return ServerResponse.ok().bodyValue(hotelService.getAll());
    }

    public Mono<ServerResponse> addHotel(ServerRequest serverRequest){

        return serverRequest.bodyToMono(Hotel.class).map(a->{
                    System.out.println("Print"+a.toString());
            return a;
                }).flatMap(a-> hotelService.addHotel(a))
                .flatMap(a-> ServerResponse.ok().bodyValue(a))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
