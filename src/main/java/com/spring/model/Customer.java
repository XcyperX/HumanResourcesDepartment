package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String secondName;

    private String email;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

//    @OneToMany(mappedBy = "customer")
//    private List<OrderHistory> orderHistories;


//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "customer")
    private OrderHistory orderHistories;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }
}
