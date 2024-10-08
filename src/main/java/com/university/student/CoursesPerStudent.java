package com.university.student;

import com.university.course.Course;

import java.util.List;

public class CoursesPerStudent {
    public CoursesPerStudent(List<String[]> data, List<Student> students, List<Course> courses) {
        addCoursesPerStudent(data, students, courses);
    }

    public void addCoursesPerStudent(List<String[]> data, List<Student> students, List<Course> courses) {
        for (Student student : students) {
            for (String[] datum : data) {
                if (datum[2].equals(student.getName())) { // me fijo si el estudiante que tengo es el mismo de esa linea
                    for (Course course : courses) {
                        if (course.getSubject().equals(datum[1])) { // me fijo la materia que cursa
                            if (!student.getSubjects().contains(course)) {
                                student.addSubject(course); // lo agrega a la lista de materias que cursa el estudiante
                                break;
                            }

                        }
                    }
                }
            }
        }
    }
}

