package com.hot3.hotelService.Service;

import com.hot3.hotelService.Model.Hotel;
import com.hot3.hotelService.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public Flux<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Mono<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    public Mono<Hotel> createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Mono<Hotel> updateHotel(String id, Hotel hotel) {
        return hotelRepository.findById(id)
                .flatMap(existingHotel -> {
                    existingHotel.setName(hotel.getName());
                    existingHotel.setCity(hotel.getCity());
                    existingHotel.setRating(hotel.getRating());
                    return hotelRepository.save(existingHotel);
                });
    }

    public Mono<Void> deleteHotel(String id) {
        return hotelRepository.deleteById(id);
    }
}
