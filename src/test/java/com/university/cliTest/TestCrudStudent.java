package com.university.cliTest;

import com.university.cli.entities.CrudStudent;
import com.university.course.Course;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCrudStudent {
    private CrudStudent crudStudent;
    @BeforeEach
    public void setUp(){
        crudStudent = new CrudStudent();
    }
    @Test
    public void testCreate(){
        Student student = new Student("Jaz", "jaz@mail");
        student.setId(1);
        crudStudent.create(student);
        assertTrue(crudStudent.getMap().containsKey(1));
        assertEquals(student, crudStudent.getMap().get(1));
    }
    @Test
    public void testRead(){
        Student student = new Student("Jaz", "jaz@mail");
        student.setId(2);
        crudStudent.create(student);
        assertEquals(student, crudStudent.read(student.getId()));
    }
    @Test
    public void testUpdate(){
        Student student = new Student("Jaz", "jaz@mail");
        student.setId(3);
        crudStudent.create(student);
        Student student1 = new Student("Sofi", "sofi@mail");
        crudStudent.update(3, student1);
        assertEquals(student1, crudStudent.getMap().get(3));
    }
    @Test
    public void testDelete(){
        Student student = new Student("Jaz", "jaz@mail");
        student.setId(4);
        crudStudent.create(student);
        crudStudent.delete(4);
        assertFalse(crudStudent.getMap().containsKey(4));
    }
    @Test
    public void testGetters(){
        Student student = new Student("Jaz", "jaz@mail");
        student.setId(5);
        crudStudent.create(student);

        assertEquals("Student", crudStudent.getIdentifier());
        assertEquals(Student.class, crudStudent.getEntityClass());
    }
}
