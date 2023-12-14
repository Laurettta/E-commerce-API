package com.Morpheus.Ecommerce.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Morpheus.Ecommerce.API.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
