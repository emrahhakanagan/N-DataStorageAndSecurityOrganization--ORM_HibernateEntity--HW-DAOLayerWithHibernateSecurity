package com.agan.layerdao_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;

}
