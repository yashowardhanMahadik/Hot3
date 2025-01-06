package com.hot3.HotelServiceApp.service;

import com.hot3.HotelServiceApp.model.Hotel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {
    public Mono<Hotel> addHotel(Hotel hotel);
    public Mono<Hotel> getHotelByName(String name);
    public Flux<Hotel> getAll();
}
