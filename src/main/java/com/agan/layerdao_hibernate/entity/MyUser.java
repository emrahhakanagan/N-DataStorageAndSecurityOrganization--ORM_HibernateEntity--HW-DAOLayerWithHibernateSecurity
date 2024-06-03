package com.agan.layerdao_hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "orm_hibernate_hw", name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login_phone_number", unique = true)
    private String loginPhoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles;

    @OneToOne
    @JoinColumn(name = "login_phone_number", referencedColumnName = "phone_number", insertable = false, updatable = false)
    @JsonBackReference
    private Person person;
}
