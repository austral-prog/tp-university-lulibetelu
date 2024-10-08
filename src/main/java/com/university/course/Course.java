package com.university.course;

import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String subject;
    private String classroom;
    private String teacher;
    private List<Student> students;

    public Course(String classroom, String subject , String teacher){
        this.subject = subject;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

}
