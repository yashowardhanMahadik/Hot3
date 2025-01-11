package com.hotl4.BadHotel.Repository;

import com.hotl4.BadHotel.Model.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel,String> {
}
