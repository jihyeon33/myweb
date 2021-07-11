package com.example.springproject1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.CheckedOutputStream;

@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPerson(){
        Person person= new Person();
        person.setName("민지현");
        person.setAge(25);
        person.setAddress("경기도 광주");
        person.setJob("프로그래머");
        return person;
    }

}
