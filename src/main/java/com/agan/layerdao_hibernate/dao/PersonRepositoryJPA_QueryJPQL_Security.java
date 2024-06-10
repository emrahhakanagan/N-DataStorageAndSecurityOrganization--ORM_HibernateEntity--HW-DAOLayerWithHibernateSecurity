package com.agan.layerdao_hibernate.dao;

import com.agan.layerdao_hibernate.entity.Person;
import com.agan.layerdao_hibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositoryJPA_QueryJPQL_Security extends JpaRepository<Person, PersonId> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("FROM Person WHERE age < :age ORDER BY age ASC") // I used here short "JPQL" option
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query("FROM Person WHERE name = :name AND surname = :surname") // I used here short "JPQL" option
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
