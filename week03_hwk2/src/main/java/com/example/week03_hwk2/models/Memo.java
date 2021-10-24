package com.example.week03_hwk2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(MemoRequestDto requestDto){
        this.username= requestDto.getUsername();
        this.contents= requestDto.getContents();
    }
    public void update(MemoRequestDto requestDto){
        this.username=requestDto.getUsername();
        this.contents=requestDto.getContents();

    }
}
