package com.university.student;

import com.university.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String email;
    private List<Course> subjects;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
    public List<Course> getSubjects() {
        return subjects;
    }
    public void addSubject(Course course){
        subjects.add(course);
    }
    public int courseCount(){
        return subjects.size();
    }
}
