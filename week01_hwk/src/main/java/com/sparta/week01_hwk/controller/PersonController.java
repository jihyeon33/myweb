package com.sparta.week01_hwk.controller;

import com.sparta.week01_hwk.models.Person;
import com.sparta.week01_hwk.models.PersonRepository;
import com.sparta.week01_hwk.models.PersonRequestDto;
import com.sparta.week01_hwk.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    //1주차 숙제
    /*
    @GetMapping("/myinfo")
    public Person getPersonInfo(){
        Person person = new Person();
        person.setName("손흥민");
        person.setAge(28);
        person.setAddress("런던");
        person.setJob("대한민국 축구선수");

        return person;

    }
     */
    //2주차 숙제

    @GetMapping("/api/persons")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){
        Person person = new Person(requestDto);
        return personRepository.save(person);

    }
    @PutMapping("api/persons/{id}")
    public Long updatePerson(@PathVariable Long id,@RequestBody PersonRequestDto requestDto){
        return personService.update(id,requestDto);
    }
    @DeleteMapping("api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;

    }



}
