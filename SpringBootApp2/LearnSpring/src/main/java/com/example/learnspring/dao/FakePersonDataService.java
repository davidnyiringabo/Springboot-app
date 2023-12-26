package com.example.learnspring.dao;

import com.example.learnspring.modal.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository("fakedao")
public class FakePersonDataService implements PersonDAO{
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    public List<Person> selectAllPeople(){
        return DB;
    }

    public Optional<Person> getPersonById(UUID id){
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public int updatePerson(UUID id, Person person){
        return getPersonById(id)
                .map(persn -> {
                    int indexOfPerson = DB.indexOf(persn);
                    if(indexOfPerson >= 0){
                        DB.set(indexOfPerson, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
    public String deletePerson(UUID id) {
        System.out.println(id);
        Iterator<Person> iterator = DB.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getId().equals(id)) {
                iterator.remove();
                return "Deleted Successfully";
            }
        }
        return "That Person Isn't in the Database.";
    }
}
