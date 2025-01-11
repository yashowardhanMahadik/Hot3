package com.hotl4.BadHotel.Service;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Model.Hotel;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface HotelService {
    public Mono<Hotel> addHotel(Hotel hotel);
    public Mono<ServerResponse> addHotel2(HotelDTO hotel);
}
