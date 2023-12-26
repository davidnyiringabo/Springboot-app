package com.example.learnspring.dao;

import com.example.learnspring.modal.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);
    List<Person> selectAllPeople();
    String deletePerson(UUID id);
    Optional<Person> getPersonById(UUID id);

    int updatePerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id  = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
