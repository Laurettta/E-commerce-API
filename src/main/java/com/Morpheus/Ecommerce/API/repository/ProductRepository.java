package com.Morpheus.Ecommerce.API.repository;

import com.Morpheus.Ecommerce.API.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
