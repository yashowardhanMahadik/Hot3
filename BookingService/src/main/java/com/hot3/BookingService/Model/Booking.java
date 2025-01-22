package com.hot3.BookingService.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "BookingsCollection")
@Data
public class Booking {

    @Id
    private String bookingId;

    private String userName;
    private String HotelName;
    private Map<RoomType,Integer> rooms;
    private PaymentStatus paymentStatus;
    private boolean isConfirmed;
}
