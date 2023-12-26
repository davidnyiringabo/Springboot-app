package com.example.learnspring.api;

import com.example.learnspring.modal.Person;
import com.example.learnspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getAllPeople();
    }

    @DeleteMapping(path = "{id}")
    public String deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable UUID id, @RequestBody Person newPersonData){
        System.out.println("This is the passed ID    -->>" + id);
        return personService.updatePerson(id, newPersonData);
    }

}
