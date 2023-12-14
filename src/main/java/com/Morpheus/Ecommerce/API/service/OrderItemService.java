package com.Morpheus.Ecommerce.API.service;

import com.Morpheus.Ecommerce.API.dto.OrderItemDTO;
import com.Morpheus.Ecommerce.API.model.Order;
import com.Morpheus.Ecommerce.API.model.OrderItem;
import com.Morpheus.Ecommerce.API.model.Product;
import com.Morpheus.Ecommerce.API.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemService {


    private final OrderItemRepository orderItemRepository;


    public OrderItem createOrderItem(OrderItemDTO orderItemDTO, Product product, Order order) {

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setSubtotal(product.getPrice() * orderItemDTO.getQuantity());
        return orderItemRepository.save(orderItem);
    }
}
