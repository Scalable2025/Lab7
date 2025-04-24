package com.example.orders.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8081/inventory")
public interface InventoryClient {
    @GetMapping("/check/{amount}")
    boolean check(@PathVariable int amount);
}
