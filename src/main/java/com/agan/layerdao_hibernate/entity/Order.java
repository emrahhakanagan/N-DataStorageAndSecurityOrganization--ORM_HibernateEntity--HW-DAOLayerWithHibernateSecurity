package com.agan.layerdao_hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "orm_hibernate_hw", name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
    @JoinColumns({
            @JoinColumn(name = "customer_name", referencedColumnName = "name"),
            @JoinColumn(name = "customer_surname", referencedColumnName = "surname"),
            @JoinColumn(name = "customer_age", referencedColumnName = "age")
    })
    @JsonBackReference
    private Person person;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_type")
    private String paymentType;

}