package com.example.exceptionHandling.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

//是在Spring 3.2新增的annotation，可以用來攔截並處理應用程式中全部Controller所拋出的Exception例外錯誤。
// 其也是@Component，所以會被Spring scan為Bean
@ControllerAdvice
public class ProductExceptionHandler {

    // 編寫客製的exception

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleExcpetion(ProductException exc){

        ProductErrorResponse error = new ProductErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("我客製化的找不到東西exception喔!");
        error.setTimeStamp(LocalDateTime.now());
        error.setDescription(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // 新增一個可以抓住所有excetion的handler

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleExcpetion(Exception exc){

        ProductErrorResponse error = new ProductErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("所有的Eection都會被這個接住!");
        error.setTimeStamp(LocalDateTime.now());
        error.setDescription(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
