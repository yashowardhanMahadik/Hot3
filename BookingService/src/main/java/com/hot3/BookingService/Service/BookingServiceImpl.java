package com.hot3.BookingService.Service;

import com.hot3.BookingService.Exception.RoomNotFoundException;
import com.hot3.BookingService.Model.Booking;
import com.hot3.BookingService.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;


    public Mono<ResponseEntity<Booking>> createBooking(Booking booking) {
        System.out.println("Bookign hotel name Is : "+booking.getHotelName());
        Mono<Booking> bookingMono = bookingRepository.save(booking);
        return bookingMono.map(booking1 -> ResponseEntity.status(HttpStatus.CREATED).body(booking1));
    }

    public Mono<ResponseEntity<Boolean>> deleteBooking(Booking booking) {
        return null;
    }

    public Mono<ResponseEntity<Booking>> getBooking(String bookId) {
        Mono<Booking> bookingMono = bookingRepository.getBookingByBookingId(bookId);
        return bookingMono.map(booking -> ResponseEntity.status(HttpStatus.FOUND).body(booking))
                .onErrorMap(e-> new RoomNotFoundException("Room retrival fail",e));
    }
}
