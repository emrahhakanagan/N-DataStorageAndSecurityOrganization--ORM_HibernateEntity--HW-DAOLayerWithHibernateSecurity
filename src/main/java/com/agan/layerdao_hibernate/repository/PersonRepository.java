package com.agan.layerdao_hibernate.repository;

import com.agan.layerdao_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        String query = "SELECT p FROM Person p WHERE p.cityOfLiving = :city";
        List<Person> persons;

        try {
            persons = entityManager.createQuery(query, Person.class)
                    .setParameter("city", city)
                    .getResultList();
        } catch (RuntimeException e) {
            System.out.println("Error:" + e);
            return null;
        }

        return persons;
    }


}
