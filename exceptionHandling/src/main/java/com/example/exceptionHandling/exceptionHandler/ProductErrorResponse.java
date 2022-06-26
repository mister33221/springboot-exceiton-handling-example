package com.example.exceptionHandling.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime timeStamp;
    private String description;

}
