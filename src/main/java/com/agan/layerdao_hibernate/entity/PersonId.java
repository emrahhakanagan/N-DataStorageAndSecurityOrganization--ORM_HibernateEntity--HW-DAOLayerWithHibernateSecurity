package com.agan.layerdao_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonId implements Serializable {

    protected String name;
    private String surname;
    private int age;

}
