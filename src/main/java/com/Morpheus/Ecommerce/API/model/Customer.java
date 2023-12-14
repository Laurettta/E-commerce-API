package com.Morpheus.Ecommerce.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Long getId() {
        return null;
    }

    public void setName(String name) {
    }

    public void setAddress(String address) {
    }

    public void setPhoneNumber(String phoneNumber) {
    }

    public void setEmail(String email) {
    }
}
