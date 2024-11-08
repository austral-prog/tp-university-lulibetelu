package com.university.courseTest;

import com.university.course.Course;
import com.university.course.CreateCourses;
import com.university.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreateCourses {
    @Test
    public void testCreateCourse(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        CreateCourses newCourse = new CreateCourses(data);

        assertEquals("Political Science", newCourse.getCourses().get(0).getSubject());
        assertEquals("578", newCourse.getCourses().get(0).getClassroom());
        assertEquals("Prof. Sam", newCourse.getCourses().get(0).getTeacher());

        assertEquals(1, newCourse.getCourses().size());
    }

    @Test
    public void testCreateDuplicatedCourse(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        CreateCourses newCourse = new CreateCourses(data);

        assertEquals(1, newCourse.getCourses().size());
    }
    @Test
    public void testID(){
        Course course = new Course("15", "Math", "Sam");
        course.setId(6);
        assertEquals(6, course.getId());

    }
}
