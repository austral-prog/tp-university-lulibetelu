package com.university.AppTest.studentTest;

import com.university.student.CreateStudent;
import com.university.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreateStudents {
    @Test
    public void testCreateStudents(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        CreateStudent newStudent = new CreateStudent(data);

        assertEquals("Olivia Red", newStudent.getStudents().getFirst().getName());
        assertEquals("olivia.red@student.org", newStudent.getStudents().getFirst().getEmail());

        assertEquals(1, newStudent.getStudents().size());
    }
    @Test
    public void testCreateDuplicatedStudent(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});
        data.add(new String[]{"578", "Political Science", "Olivia Red", "olivia.red@student.org", "Prof. Sam"});

        CreateStudent newStudent = new CreateStudent(data);

        assertEquals(1, newStudent.getStudents().size());
    }

    @Test
    public void test2ToStringForSolution(){
        Student student= new Student("Facu", "facu@mail");
        assertEquals("Facu,0",student.toStringForSolution());
    }
}

