package com.example.orders.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String createOrder() {
        // TODO:Check if inventory is available using OpenFeign

        // TODO:Send a message to shipping for order creation

        return "Order created successfully!";
    }
}
