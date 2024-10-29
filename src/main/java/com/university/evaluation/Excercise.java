package com.university.evaluation;

public class Excercise {
    private String name;
    private String grade;
    public Excercise(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
    public Float getGrade(){
        return Float.parseFloat(grade);
    }
    public String getName(){
        return name;
    }
}
