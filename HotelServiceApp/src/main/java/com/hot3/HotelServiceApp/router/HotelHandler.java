package com.hot3.HotelServiceApp.router;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Service
@AllArgsConstructor
public class HotelHandler {

    private final HotelService hotelService;

    public Mono<ServerResponse> getAllHotels(ServerRequest serverRequest){
        return ServerResponse.ok().bodyValue(hotelService.getAll());
    }

    public Mono<ServerResponse> addHotel(ServerRequest request){

        return request.bodyToMono(Hotel.class).map(a->{
                    System.out.println("Print"+a.toString());
            return a;
                }).flatMap(a-> hotelService.addHotel(a))
                .flatMap(a-> ServerResponse.ok().bodyValue(a))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> addHotel(Hotel hotel){
        System.out.println("Hptel service call : "+hotel.toString());
        Mono<Hotel> hotelMono = hotelService.addHotel(hotel);
        return hotelMono.flatMap(htl->ServerResponse.ok().bodyValue(htl));
//                .onErrorContinue(e->throw new RuntimeException("as"));
//                ;
    }
}
