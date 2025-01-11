package com.hotl4.BadHotel.Exception;

public class EmptyException extends Exception{
    public EmptyException(String e){
        super("Empty Record -> "+e);
    }
}
