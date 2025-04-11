package com.example.orders.controller;

import com.example.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{amount}")
    public String createOrder(@PathVariable int amount) {
        return "this.orderService.createOrder(amount);";
    }
}
