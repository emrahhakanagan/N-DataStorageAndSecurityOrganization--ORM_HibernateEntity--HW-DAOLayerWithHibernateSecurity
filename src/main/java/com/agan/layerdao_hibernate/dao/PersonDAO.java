package com.agan.layerdao_hibernate.dao;

import com.agan.layerdao_hibernate.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> getPersonsByCity(String city);

}
