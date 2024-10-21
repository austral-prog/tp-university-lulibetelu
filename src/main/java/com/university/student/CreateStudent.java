package com.university.student;

import com.university.course.CreateCourses;

import java.util.ArrayList;
import java.util.List;

public class CreateStudent {
    private List<Student> students;
    public CreateStudent(List<String[]> data){
        this.students = new ArrayList<>();
        createStudent(data);
    }
    public void createStudent(List<String[]> data){
        for (int i = 0; i < data.size(); i++) {  // recorro las listas
            int count = 0;
            boolean found = false;
            while (count < students.size()) {
                if (students.get(count).getName().equals(data.get(i)[2]) ) {
                    found = true;  // checkeo si el estudiante ya fue creado y si esta en la lista de students
                    break;
                }
                count++;
            }
            if (!found) {
                Student student = new Student(data.get(i)[2], data.get(i)[3]);
                students.add(student);
            }

        }
    }
    public List<Student> getStudents(){
        return students;
    }




}
