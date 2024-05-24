package com.agan.layerdao_hibernate.entity;

import com.agan.layerdao_hibernate.entity.enums.PaymentType;
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
    @JoinColumn(name = "customer_id", nullable = false)
    private Person person;

    @Id
    @Column(name = "date")
    private Date date;

    @Id
    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_type")
    private PaymentType paymentType;

}