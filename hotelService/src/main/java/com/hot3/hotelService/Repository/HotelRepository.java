package com.hot3.hotelService.Repository;

import com.hot3.hotelService.Model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {
}
