package com.programming.microservice2.orderservice.controller;

import com.programming.microservice2.orderservice.client.InventoryClient;
import com.programming.microservice2.orderservice.dto.OrderDto;
import com.programming.microservice2.orderservice.model.Order;
import com.programming.microservice2.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;



    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto){

        boolean allProductsInStock = orderDto.getOrderLineItemsList().stream()
                .allMatch(orderLineItems -> inventoryClient.checkStock(orderLineItems.getSkuCode()));

        if(allProductsInStock)
        {
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());

            orderRepository.save(order);

            return "Order Placed Successfully";
        }
        else{
            return "Order Failed, One of the products is not in stock";
        }
    }
}