package com.hotl4.BadHotel.Service.ServiceImpl;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Repository.HotelRepository;
import com.hotl4.BadHotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repo;

    public Mono<Hotel> addHotel(Hotel hotel){
        // add the request validations later
        // add DTO instead of hte hotel object
        // see if fallback value is needed or not ?
        return repo.save(hotel);
        //return runtime error accordingly in custom class
        //unit tests need to be added later
    }

    public Mono<ServerResponse> addHotel2(HotelDTO hotel) {
        Mono<Hotel> hotelMono = repo.save(HotelDTO.convertHotel(hotel));
        return ServerResponse.ok().bodyValue(HotelDTO.convertDTO(hotelMono));
    }

}
