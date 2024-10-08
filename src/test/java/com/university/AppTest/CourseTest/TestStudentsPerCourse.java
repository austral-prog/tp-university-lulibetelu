package com.university.AppTest.CourseTest;

import com.university.course.CreateCourses;
import com.university.course.StudentsPerCourse;
import com.university.student.CreateStudent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStudentsPerCourse {
    @Test
    public void testStudentsPerCourse() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        data.add(new String[]{"113", "Political Science", "Alice Orange", "alice.orange@university.edu", "Prof. Nick"});

        CreateCourses newCourses = new CreateCourses(data);
        CreateStudent newStudents = new CreateStudent(data);
        StudentsPerCourse studentsPerCourse = new StudentsPerCourse(data, newStudents.getStudents(), newCourses.getCourses());

        assertEquals(3, newCourses.getCourses().get(0).getStudents().size());
        assertEquals("Olivia Red", newCourses.getCourses().getFirst().getStudents().getFirst().getName());
        assertEquals("Alice Orange", newCourses.getCourses().getFirst().getStudents().get(1).getName());
    }

    @Test
    public void testRepeatedStudent() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});

        CreateCourses newCourses = new CreateCourses(data);
        CreateStudent newStudents = new CreateStudent(data);
        StudentsPerCourse studentsPerCourse = new StudentsPerCourse(data, newStudents.getStudents(), newCourses.getCourses());

        assertEquals(1, newCourses.getCourses().get(0).getStudents().size());
    }
}


