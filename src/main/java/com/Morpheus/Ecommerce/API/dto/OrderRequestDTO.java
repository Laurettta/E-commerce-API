package com.Morpheus.Ecommerce.API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private Long customerId;

    private ArrayList<OrderItemDTO> products;
}
