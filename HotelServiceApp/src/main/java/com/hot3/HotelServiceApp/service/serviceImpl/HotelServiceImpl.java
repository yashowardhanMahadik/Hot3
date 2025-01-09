package com.hot3.HotelServiceApp.service.serviceImpl;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.repository.HotelRepository;
import com.hot3.HotelServiceApp.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    // CRUD Add
    public Mono<Hotel> addHotel(Hotel hotel){
        System.out.println("Servec impl call : "+hotel.toString());

        return hotelRepository.save(hotel);
//                .onErrorReturn(new Hotel())
//                .switchIfEmpty(null);
    }
    // Get one
    public Mono<Hotel> getHotelByName(String name){
        return hotelRepository.findByName(name);
    }
    //GetAll
    public Flux<Hotel> getAll(){
        return hotelRepository.findAll();
    }
}
