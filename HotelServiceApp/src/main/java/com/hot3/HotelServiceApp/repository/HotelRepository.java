package com.hot3.HotelServiceApp.repository;

import com.hot3.HotelServiceApp.model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {
    public Mono<Hotel> findByName(String name);
}
