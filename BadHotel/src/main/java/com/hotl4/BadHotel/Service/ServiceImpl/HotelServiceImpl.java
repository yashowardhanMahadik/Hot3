package com.hotl4.BadHotel.Service.ServiceImpl;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Exception.DuplicateKeyException;
import com.hotl4.BadHotel.Exception.EmptyException;
import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Repository.HotelRepository;
import com.hotl4.BadHotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repo;

    public Mono<Hotel> addHotel(Hotel hotel){
        // add the request validations later
        // add DTO instead of hte hotel object
        // see if fallback value is needed or not ?
        System.out.println("hotel Service impl: "+hotel.toString());
        return repo.save(hotel)
                .onErrorMap(e->  {
                    return new DuplicateKeyException(e.getMessage());
                });
    }

    public Mono<ServerResponse> addHotel2(HotelDTO hotelDTO) {
        Mono<Hotel> hotelMono = repo.save(hotelDTO.convertHotel2());
        return ServerResponse.ok().bodyValue(HotelDTO.convertDTO(hotelMono));
    }

    @Override
    public Mono<ServerResponse> addHotel3(Hotel hotel) {
//        Mono<Hotel> hotelMono = repo.save(hotel);
//        hotelMono.map(ht-> {
//            log.debug(ht.toString());
//            return null;
//        });
//        System.out.println("Executes : ");
//        return ServerResponse.ok().body(hotelMono,Hotel.class);
        return repo.save(hotel)
                .flatMap(hotel1->
                    ServerResponse.ok()
                            .bodyValue(hotel1)
                ).switchIfEmpty(ServerResponse.notFound().build()) // Handle empty Mono properly
                .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .bodyValue("Error occurred: " + e.getMessage()));
    }

    public Mono<ResponseEntity<Hotel>> addHotel5(HotelDTO hotelDTO){
        return repo.save(hotelDTO.convertHotel2())
                .onErrorMap(e-> new RuntimeException("DB Unable to save -> "+e.getMessage()))
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new EmptyException("Repsponse came empty")));
    }

    @Override
    public ResponseEntity<Flux<Hotel>> getAllHotels() {
        Flux<Hotel> hotelFlux = repo.findAll();
        return ResponseEntity.ok(hotelFlux);

    }

    @Override
    public Mono<ResponseEntity<Hotel>> getByName(String hotelName) {
        return repo.findByName(hotelName)
                .onErrorMap(e -> new RuntimeException("DB unable to fetch "+ e.getMessage()))
                .switchIfEmpty(Mono.error(new EmptyException("Response Empty")))
                .map(ResponseEntity::ok);
    }


}
