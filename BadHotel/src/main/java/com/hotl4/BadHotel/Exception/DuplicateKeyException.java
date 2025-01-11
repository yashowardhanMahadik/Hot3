package com.hotl4.BadHotel.Exception;

public class DuplicateKeyException extends Exception{
    public DuplicateKeyException(String e){
        super("Duplicate Name occured -> "+e);
    }
}
