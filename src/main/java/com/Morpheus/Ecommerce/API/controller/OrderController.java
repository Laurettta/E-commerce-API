package com.Morpheus.Ecommerce.API.controller;

import com.Morpheus.Ecommerce.API.dto.OrderRequestDTO;
import com.Morpheus.Ecommerce.API.dto.OrderResponseDTO;
import com.Morpheus.Ecommerce.API.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Object createdOrder = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {

        return ResponseEntity.ok().build();
    }
}
