package com.sparta.week01.prac;

public class Tutor {
    private String name;
    private int bio;
    //생성자
    public Tutor(){}
    public Tutor(String name,int bio){
        this.name=name;
        this.bio=bio;
    }
    //setter
    public void setName(String name){
        this.name=name;
    }
    public void setBio(int bio){
        this.bio=bio;
    }
    //getter
    public String getName(){
        return this.name;
    }
    public int getBio(){
        return this.bio;
    }
}
