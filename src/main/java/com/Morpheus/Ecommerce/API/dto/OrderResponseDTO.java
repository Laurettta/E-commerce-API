package com.Morpheus.Ecommerce.API.dto;

import com.Morpheus.Ecommerce.API.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderResponseDTO {

    private Long id;

    private Long customerId;

    private LocalDateTime orderDate;

    private Double totalAmount;

    private ArrayList<OrderItem> orderItems;
}
