package com.example.exceptionHandling.exceptionHandler;

public class ProductException extends RuntimeException {

    public ProductException(String message, Throwable cause){
        super(message, cause);
    }

    public ProductException(Throwable cause){
        super(cause);
    }

    public ProductException(String s) {
    }
}
