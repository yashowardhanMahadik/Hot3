package com.hotl4.BadHotel.Service;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {
    public Mono<Hotel> addHotel(Hotel hotel);
    public Mono<ServerResponse> addHotel2(HotelDTO hotel);
    public Mono<ServerResponse> addHotel3(Hotel hotel);
    public Mono<ResponseEntity<Hotel>> addHotel5(HotelDTO hotelDTO);

    public ResponseEntity<Flux<Hotel>> getAllHotels();
    public Flux<Hotel> getAllHotels(int page, int size);

    public Mono<ResponseEntity<Hotel>> getByName(String hotelName);
}
