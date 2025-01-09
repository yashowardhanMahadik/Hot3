package com.hot3.HotelServiceApp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "Hotels")
@Data
public class Hotel {

     @Id
     private String hotel_id;

    @NotNull
    @Indexed(unique = true)
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String city;
     private List<Room> rooms;

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id='" + hotel_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
