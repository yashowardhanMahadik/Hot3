package com.hot3.BookingService.Controller;

import com.hot3.BookingService.Model.Booking;
import com.hot3.BookingService.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookingController {
    private BookingService bookingService;
    @PostMapping("/create")
    public Mono<ResponseEntity<Booking>> createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }
}
