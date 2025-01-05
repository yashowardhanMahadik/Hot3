package com.hot3.userService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    public class ErrorResponse{
        private final int errorCode;
        private final String errorMsg;

        public ErrorResponse(int errorCode, String errorMsg) {
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }
    }
    @ExceptionHandler(UserInvalidsException.class)
    public ResponseEntity<?> userInvalidExceptionExceptions(UserInvalidsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT.value(),
                        e.getMessage()));
    }
    // Validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception e){
//        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
//                .body(new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),
//                        e.getMessage()));
//    }
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse(400, ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}

}
