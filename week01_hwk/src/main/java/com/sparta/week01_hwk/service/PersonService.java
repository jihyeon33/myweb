package com.sparta.week01_hwk.service;

import com.sparta.week01_hwk.models.Person;
import com.sparta.week01_hwk.models.PersonRepository;
import com.sparta.week01_hwk.models.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto){
        Person person= personRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person.update(requestDto);
        return person.getId();

    }
}