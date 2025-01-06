package com.hot3.HotelServiceApp.model;

import lombok.AllArgsConstructor;
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

}
