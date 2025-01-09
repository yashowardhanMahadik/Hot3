package com.hot3.HotelServiceApp.model;

import lombok.Data;

@Data
public class Room {
    private String room_id;
    private RoomStatus status;
    private int room_no;
}
