package com.hot3.BookingService.Repository;

import com.hot3.BookingService.Model.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BookingRepository extends ReactiveMongoRepository<Booking,String> {
    Mono<Booking> getBookingByBookingId(String id);
}
