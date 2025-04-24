package com.example.shipping;

import com.example.shipping.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @RabbitListener(queues = RabbitMQConfig.SHIPPING_QUEUE)
    public void notifyShipping(String id) {
        System.out.println("Received order: " + id);
    }
}
