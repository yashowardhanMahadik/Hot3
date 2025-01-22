package com.hot3.BookingService.Model;

public abstract class RoomType {
    String name;
    String capacity;
    public RoomType(String name, String capacity) {
        this.name = name;
        this.capacity = capacity;
    }

}
