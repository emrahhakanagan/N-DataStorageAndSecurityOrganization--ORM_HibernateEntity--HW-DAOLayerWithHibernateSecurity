package com.agan.layerdao_hibernate.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "orm_hibernate_hw", name = "person")
@IdClass(PersonId.class)
public class Person {

//    @Column(name = "id", unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "surname")
    private String surname;

    @Id
    @Column(name = "age")
    private int age;

    @Column(name = "phone_number", unique = true)

    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private MyUser myUser;


}

