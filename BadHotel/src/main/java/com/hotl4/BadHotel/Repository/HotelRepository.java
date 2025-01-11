package com.hotl4.BadHotel.Repository;

import com.hotl4.BadHotel.Model.Hotel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel,String> {

    @Query(value = "{'hotelName':'?0'}")
    public Mono<Hotel> findByName(String name);
}
