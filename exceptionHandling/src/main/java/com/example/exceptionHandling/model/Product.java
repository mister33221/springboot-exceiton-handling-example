package com.example.exceptionHandling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
// 加上所有參數的建構子
@AllArgsConstructor
// 加上沒有參數的建構子
@NoArgsConstructor
public class Product {

    private Integer productId;
    private String productName;
    private Integer productPrice;

}
