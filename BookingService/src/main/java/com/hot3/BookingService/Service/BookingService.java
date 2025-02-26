package com.hot3.BookingService.Service;

import com.hot3.BookingService.Model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface BookingService {
    public Mono<ResponseEntity<Booking>> createBooking(Booking booking);

    public Mono<ResponseEntity<Boolean>> deleteBooking(Booking booking);

    public Mono<ResponseEntity<Booking>> getBooking(String bookId);
}
