//package com.hot3.HotelServiceApp.router;
//
//import com.hot3.HotelServiceApp.model.Hotel;
//import com.hot3.HotelServiceApp.service.HotelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//@Configuration
//public class HotelRouter {
//
////    @Autowired
////    HotelHandler hotelHandler;
//
//    @Bean
//    public RouterFunction<ServerResponse> hotelsRouter(HotelHandler hotelHandler){
//        return RouterFunctions
//                .route()
//                .POST("/addHotel",hotelHandler::addHotel)
//                .GET("/getAll",hotelHandler::getAllHotels)
//                .build();
////                        .onErrorReturn(ServerResponse.notFound().build().block())
//
//
//    }
//}
