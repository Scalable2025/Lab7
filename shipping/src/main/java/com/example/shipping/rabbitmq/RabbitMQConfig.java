package com.example.shipping.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String SHIPPING_QUEUE = "shipping_queue";
    public static final String EXCHANGE = "shared_exchange";
    public static final String SHIPPING_ROUTING_KEY = "shipping_routing_key";

    @Bean
    public Queue queue() {
        return new Queue(SHIPPING_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(SHIPPING_ROUTING_KEY);
    }
}
