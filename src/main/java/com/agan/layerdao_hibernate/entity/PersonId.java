package com.agan.layerdao_hibernate.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonId implements Serializable {

//    private long id;
    private String name;
    private String surname;
    private int age;


}

