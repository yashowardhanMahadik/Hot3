package com.hotl4.BadHotel.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HotelBad")
@Data
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String city;
}
