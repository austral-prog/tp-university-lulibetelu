package com.university.cliTest;

import com.university.cli.entities.CrudCourse;
import com.university.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCrudCourse {
    private CrudCourse crudCourse;
    @BeforeEach
    public void setUp(){
        crudCourse = new CrudCourse();
    }

    @Test
    public void testCreate(){
        Course course = new Course("15", "Maths", "Sam");
        course.setId(1);
        crudCourse.create(course);
        assertTrue(crudCourse.getMap().containsKey(1));
        assertEquals(course, crudCourse.getMap().get(1));
    }
    @Test
    public void testRead(){
        Course course = new Course("15", "Maths", "Sam");
        course.setId(2);
        crudCourse.create(course);
        assertEquals(course, crudCourse.read(course.getId()));
    }
    @Test
    public void testUpdate(){
        Course course = new Course("15", "Maths", "Sam");
        course.setId(3);
        crudCourse.create(course);
        Course course2 = new Course("12", "Biology", "Sam");
        crudCourse.update(3, course2);
        assertEquals(course2, crudCourse.getMap().get(3));
    }
    @Test
    public void testDelete(){
        Course course = new Course("15", "Maths", "Sam");
        course.setId(4);
        crudCourse.create(course);
        crudCourse.delete(4);
        assertFalse(crudCourse.getMap().containsKey(4));
    }
    @Test
    public void testGetters(){
        Course course = new Course("15", "Maths", "Sam");
        course.setId(5);
        crudCourse.create(course);
        assertEquals("Course", crudCourse.getIdentifier());
        assertEquals(Course.class, crudCourse.getEntityClass());
    }
}
