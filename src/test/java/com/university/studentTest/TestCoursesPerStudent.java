package com.university.studentTest;

import com.university.course.CreateCourses;
import com.university.student.CoursesPerStudent;
import com.university.student.CreateStudent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoursesPerStudent {
    @Test
    public void testCoursesPerStudent() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        data.add(new String[]{"288", "Psychology", "Olivia Red", "olivia.red@university.edu", "Prof. Grace"});

        CreateStudent newStudent = new CreateStudent(data);
        CreateCourses newCourses = new CreateCourses(data);

        CoursesPerStudent coursesPerStudent = new CoursesPerStudent(data, newStudent.getStudents(), newCourses.getCourses());

        assertEquals(2, newStudent.getStudents().getFirst().getSubjects().size());

    }
}

