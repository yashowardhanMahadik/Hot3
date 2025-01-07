package com.hot3.HotelServiceApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "Hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
     String hotel_id;

    @NotNull
    @Indexed(unique = true)
     String name;
    @NotNull
     String address;
    @NotNull
     String city;
     List<Room> rooms;

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
