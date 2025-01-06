package com.hot3.HotelServiceApp.service.serviceImpl;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.repository.HotelRepository;
import com.hot3.HotelServiceApp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // CRUD Add
    public Mono<Hotel> addHotel(Hotel hotel){

        return Mono.just(hotel)
                .flatMap(hotelRepository::save)
                .onErrorReturn(new Hotel())
                .switchIfEmpty(null);
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
