package com.example.exceptionHandling.controller;

import com.example.exceptionHandling.exceptionHandler.ProductException;
import com.example.exceptionHandling.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private List<Product> productList;

    @PostConstruct
    public void loadStudentDate(){

        productList = new ArrayList<>();
        productList.add(new Product(1,"product1",100));
        productList.add(new Product(2,"product2",200));
        productList.add(new Product(3,"product3",300));

    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/products")
    public  List<Product> students(){
        return productList;
    }

    @GetMapping("/item/{productId}")
    public ResponseEntity<?> getStudent(@PathVariable int productId) {

        if ( (productId >= productList.size()+1) || (productId <= 0) ) {

            throw new ProductException("Student id not found - " + productId);
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new StudentNotFoundException("Student id not found - " + studentId));
        }

        return ResponseEntity.ok().body(productList.get(productId-1));

    }


}
