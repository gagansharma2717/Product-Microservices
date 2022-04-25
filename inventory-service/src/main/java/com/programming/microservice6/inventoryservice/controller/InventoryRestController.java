package com.programming.microservice6.inventoryservice.controller;

import com.programming.microservice6.inventoryservice.model.Inventory;
import com.programming.microservice6.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryRestController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/{skuCode}")
    Boolean isInStock(@PathVariable String skuCode){
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot find product by skuCode" + skuCode));
        return inventory.getStock() > 0;
    }
}
