package com.hotl4.BadHotel.DTO;

import com.hotl4.BadHotel.Model.Hotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String hotelId;
    @NotNull
    @NotBlank
    private String hotelName;
    @NotBlank
    private String hotelAddress;
    @NotEmpty
    private String city;

    public static Mono<HotelDTO> convertDTO(Mono<Hotel> hotel){
        return hotel.map(hotel1 -> {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.hotelId = hotel1.getHotelId();
            hotelDTO.hotelName = hotel1.getHotelName();
            hotelDTO.hotelAddress = hotel1.getHotelAddress();
            hotelDTO.city = hotel1.getCity();
        return hotelDTO;
        });
    }
    public static Hotel convertHotel(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setHotelAddress(hotelDTO.getHotelAddress());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setCity(hotelDTO.getCity());
        return hotel;
    }
    public Hotel convertHotel2(){
        Hotel hotel = new Hotel();
        hotel.setHotelId(this.hotelId);
        hotel.setHotelAddress(this.hotelAddress);
        hotel.setHotelName(this.hotelName);
        hotel.setCity(this.city);
        return hotel;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
