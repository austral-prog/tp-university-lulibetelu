package com.university.course;

import com.university.student.Student;

import java.util.List;

public class StudentsPerCourse {
    public StudentsPerCourse(List<String[]> data, List<Student> students, List<Course> courses){
        addStudentsPerCourse(data, students, courses);
    }
    public void addStudentsPerCourse(List<String[]> data, List<Student> students, List<Course> courses){
        for (Course course: courses){
            for (String[] datum : data) {
                if (datum[1].equals(course.getSubject())) { // me fijo si es el mismo curso
                    for (Student student : students) {
                        if (student.getName().equals(datum[2])){ // me fijo que estudiante cursa esa materia
                            if (!course.getStudents().contains(student)) {
                                course.addStudents(student); // lo agrego a la lista de estudiantes que la cursan
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
