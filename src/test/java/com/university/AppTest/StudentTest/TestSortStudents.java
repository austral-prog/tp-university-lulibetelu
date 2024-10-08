package com.university.AppTest.StudentTest;

import com.university.course.CreateCourses;
import com.university.student.CoursesPerStudent;
import com.university.student.CreateStudent;
import com.university.student.SortStudents;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSortStudents {
    @Test
    public void testSortStudents(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578","Political Science","Olivia Red","olivia.red@student.org","Prof. Sam"});
        data.add(new String[]{"331", "Mathematics", "Quincy Johnson", "quincy.johnson @email.com","Prof.Hank"});
        data.add(new String[]{"106", "Political Science", "Kelly Pink", "kelly.pink @university.edu","Prof.Sam"});

        CreateStudent newStudent = new CreateStudent(data);
        CreateCourses newCourse = new CreateCourses(data);
        CoursesPerStudent coursesPerStudent = new CoursesPerStudent(data, newStudent.getStudents(), newCourse.getCourses());
        SortStudents sortStudents = new SortStudents(newStudent.getStudents());

        assertEquals("Kelly Pink", sortStudents.getSortedStudents().getFirst().getName());
        assertEquals("Olivia Red", sortStudents.getSortedStudents().get(1).getName());
        assertEquals("Quincy Johnson", sortStudents.getSortedStudents().get(2).getName());
    }
}
