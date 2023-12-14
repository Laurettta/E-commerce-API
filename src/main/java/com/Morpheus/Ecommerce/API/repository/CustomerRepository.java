package com.Morpheus.Ecommerce.API.repository;

import com.Morpheus.Ecommerce.API.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface CustomerRepository extends JpaRepository<Customer, Long> {

    }


