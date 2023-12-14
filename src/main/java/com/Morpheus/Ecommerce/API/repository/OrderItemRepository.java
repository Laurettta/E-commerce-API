package com.Morpheus.Ecommerce.API.repository;


import com.Morpheus.Ecommerce.API.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
