package com.university.AppTest;

import com.university.App;
import com.university.course.Course;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    private App app;

    @BeforeEach
    public void setup() {
        // Inicializa el objeto App
        app = new App();
        //app.main(null);
    }

    @Test
    public void testCreateStudents(){
        List<Student> students = app.getStudents();
        assertNotNull(students);
//        for (Student student: students){
//            int count = 0;
//            //if (student)
//            assertEquals(1, students.contains(student));
//        }

        for (Student student: students) {
            for (int i = 0; i < students.size(); i++) {
                if (student.equals(students.get(i)));
            }
        }

    }
    @Test
    public void testCreateCourses(){
        List<Course> courses = app.getCourses();
        assertNotNull(courses);
        for (Course course: courses){
            assertEquals(1, courses.contains(course));
        }
    }

}
