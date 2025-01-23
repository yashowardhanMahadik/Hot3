package com.hot3.BookingService.Repository;

import com.hot3.BookingService.Model.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookingRepository extends ReactiveMongoRepository<Booking,String> {
}
