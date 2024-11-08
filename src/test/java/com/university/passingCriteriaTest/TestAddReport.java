package com.university.passingCriteriaTest;

import com.university.course.Course;
import com.university.passingCriteria.criteria.AverageAboveValue;
import com.university.passingCriteria.criteria.MaxAboveValue;
import com.university.passingCriteria.criteria.MinAboveValue;
import com.university.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddReport {
    @Test
    public void testAddTrueReportMin(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 7.0);
        grades.add((float) 8.0);
        MinAboveValue p1 = new MinAboveValue();
        boolean pass = p1.approved(grades, 6);

        student.addReport(course.getSubject(), pass);
        assertTrue(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertTrue(student.getReport().get(course.getSubject()).getFirst());

    }
    @Test
    public void testAddFalseReportMin(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 5.0);
        grades.add((float) 8.0);
        MinAboveValue p1 = new MinAboveValue();
        boolean pass = p1.approved(grades, 6);

        student.addReport(course.getSubject(), pass);
        assertFalse(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertFalse(student.getReport().get(course.getSubject()).getFirst());
    }
    @Test
    public void testAddTrueReportMax(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 5.0);
        MaxAboveValue p1 = new MaxAboveValue();
        boolean pass = p1.approved(grades, 6);
        student.addReport(course.getSubject(), pass);

        assertTrue(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertTrue(student.getReport().get(course.getSubject()).getFirst());
    }
    @Test
    public void testAddFalseReportMax(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 7.0);
        MaxAboveValue p1 = new MaxAboveValue();
        boolean pass = p1.approved(grades, 6);
        student.addReport(course.getSubject(), pass);

        assertFalse(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertFalse(student.getReport().get(course.getSubject()).getFirst());
    }
    @Test
    public void testAddTrueReportAverage(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 6.0);
        grades.add((float) 8.0);
        AverageAboveValue p1 = new AverageAboveValue();
        boolean pass = p1.approved(grades, 6);
        student.addReport(course.getSubject(), pass);

        assertTrue(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertTrue(student.getReport().get(course.getSubject()).getFirst());
    }
    @Test public void testAddFalseReportAverage(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 3.0);
        grades.add((float) 7.0);
        AverageAboveValue p1 = new AverageAboveValue();
        boolean pass = p1.approved(grades, 6);
        student.addReport(course.getSubject(), pass);

        assertFalse(pass);
        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(1, student.getReport().get(course.getSubject()).size());
        assertFalse(student.getReport().get(course.getSubject()).getFirst());
    }
    @Test
    public void testAddMultipleReports(){
        Student student = new Student("Juan", "juan@mail");
        Course course = new Course("555", "Maths", "Sam");
        List<Float> grades = new ArrayList<>();
        grades.add((float) 5.0);
        grades.add((float) 8.0);

        List<Float> tpFinal = new ArrayList<>();
        tpFinal.add((float) 8.0);

        MinAboveValue p1 = new MinAboveValue();
        boolean pass1 = p1.approved(grades, 5);
        student.addReport(course.getSubject(), pass1);

        MaxAboveValue p2 = new MaxAboveValue();
        boolean pass2 = p2.approved(tpFinal, 7);
        student.addReport(course.getSubject(), pass2);

        AverageAboveValue p3 = new AverageAboveValue();
        boolean pass3 = p3.approved(grades, 4);
        student.addReport(course.getSubject(), pass3);


        assertFalse(student.getReport().get(course.getSubject()).isEmpty());
        assertEquals(3, student.getReport().get(course.getSubject()).size());
        assertEquals(true, student.getReport().get(course.getSubject()).getFirst());
        assertEquals(false, student.getReport().get(course.getSubject()).get(1));
        assertEquals(true, student.getReport().get(course.getSubject()).get(2));


    }
}
