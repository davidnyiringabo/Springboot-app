package com.example.learnspring.service;

import com.example.learnspring.dao.PersonDAO;
import com.example.learnspring.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakedao") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return  personDAO.selectAllPeople();
    }

    public String deletePerson(UUID id){
        return personDAO.deletePerson(id);
    }
    public Optional<Person> getPersonById(UUID id){
        return personDAO.getPersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDAO.updatePerson(id, newPerson);
    }
}
