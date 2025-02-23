package com.hotl4.BadHotel.Controller;

import com.hotl4.BadHotel.DTO.HotelDTO;
import com.hotl4.BadHotel.Model.Hotel;
import com.hotl4.BadHotel.Service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HotelController {
    private final HotelService hotelService;

    //Router operations documentation later
    // API endpoint to add a new hotel

    /*
    todo: add DTO instead of Hotel class
    todo :add ServerResponse instead of the Hotel class
    todo: add common Exception handler as well

     */
    @PostMapping("/addHotel")
    public Mono<Hotel> addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PostMapping("/addHotel2")
    public Mono<ServerResponse> addHotel2(@RequestBody HotelDTO hotel) {
        // Server response not working dont know why
        return hotelService.addHotel2(hotel);
    }

    @PostMapping("/addHotel3")
    public Mono<ServerResponse> addHotel3(@RequestBody Hotel hotel) {
        // Server response not working dont know why
        System.out.println("hotel controller: " + hotel.toString());
        return hotelService.addHotel3(hotel);
    }

    @PostMapping("/addHotel4")
    public Mono<ResponseEntity<Hotel>> addHotel4(@RequestBody Hotel hotel) {
        System.out.println("hotel controller: " + hotel.toString());
        return hotelService.addHotel(hotel)
                .map(hotel1 -> ResponseEntity.ok(hotel1))
                .onErrorMap(e -> new RuntimeException(" This error occured : " + e.getMessage()))
                .switchIfEmpty(Mono.error(new RuntimeException("Its empty")));
    }

    @PostMapping("/addHotel5")
    public Mono<ResponseEntity<Hotel>> addHotel5(@Valid @RequestBody HotelDTO hotelDTO) {
        return hotelService.addHotel5(hotelDTO);

    }

    @GetMapping("/getAll")
    public ResponseEntity<Flux<Hotel>> getHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<Flux<Hotel>> getHotels(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Flux<Hotel> allHotels = hotelService.getAllHotels(page, size);
        return ResponseEntity.ok(allHotels);

    }

    @GetMapping("/getOne/{hotelName}")
    public Mono<ResponseEntity<Hotel>> getHotel(@PathVariable String hotelName) {
        return hotelService.getByName(hotelName);
    }

    @GetMapping("/getOne")
    public Mono<ResponseEntity<Hotel>> getHotel2(@RequestParam("hotelName") String hotelName) {
        return hotelService.getByName(hotelName);
    }

}
