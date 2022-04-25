package com.programming.microservice2.orderservice.dto;


import com.programming.microservice2.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private List<OrderLineItems> orderLineItemsList;
}
