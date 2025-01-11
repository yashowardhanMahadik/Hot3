package com.hotl4.BadHotel.Exception;

import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorResponse{
    private final int errorCode;
    private final String errorMsg;
    public ErrorResponse(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public static Map<String, String> getErrorResponse(Exception e, int status){
        Map<String,String> errorMap = new LinkedHashMap<>();
        errorMap.put("status", String.valueOf(status));
        errorMap.put("errorMessage", e.getMessage());
        errorMap.put("errorExceptionName",e.toString());
        return errorMap;
    }
}