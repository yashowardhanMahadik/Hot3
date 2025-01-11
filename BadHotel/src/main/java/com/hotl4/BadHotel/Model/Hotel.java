package com.hotl4.BadHotel.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HotelBad")
@Data
public class Hotel {
    @Id
    private String hotelId;
    @Indexed(unique = true)
    private String hotelName;
    private String hotelAddress;
    private String city;

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
