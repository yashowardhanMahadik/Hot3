package com.hot3.BookingService.Service;

import com.hot3.BookingService.Model.Booking;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface BookingService {
    public Mono<ResponseEntity<Booking>> createBooking(Booking booking);
}
