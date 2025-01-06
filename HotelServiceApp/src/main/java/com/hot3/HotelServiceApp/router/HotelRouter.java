package com.hot3.HotelServiceApp.router;

import com.hot3.HotelServiceApp.model.Hotel;
import com.hot3.HotelServiceApp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HotelRouter {

    @Autowired
    private HotelService hotelService;

    public RouterFunction<ServerResponse> hotelRouter(){
        return RouterFunctions
                .route()
                .GET("/getAll",request-> ServerResponse.ok().bodyValue(hotelService.getAll()))
                .POST("/addHotel",request -> request.bodyToMono(Hotel.class).flatMap(a-> hotelService.addHotel(a))
                        .flatMap(a-> ServerResponse.ok().bodyValue(a))
                        .switchIfEmpty(ServerResponse.notFound().build()))
                .build();



    }
}
