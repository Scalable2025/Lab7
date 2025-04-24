package com.example.orders.service;

import com.example.orders.clients.InventoryClient;
import com.example.orders.rabbitmq.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private InventoryClient inventoryClient;
    @Autowired
    private RabbitMQProducer rabbitMQProducer;
    public String createOrder(int amount){
        if(!inventoryClient.check(amount)){
            throw new RuntimeException("Not enough inventory!");
        }

        String orderId = UUID.randomUUID().toString();
        this.rabbitMQProducer.sendToShipping(orderId);

        return "Order created with ID: " + orderId;
    }
}
