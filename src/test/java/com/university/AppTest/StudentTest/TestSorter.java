package com.university.AppTest.StudentTest;

import com.university.sortable.Sorter;
import com.university.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSorter {
    private List<Student> students = new ArrayList<>();
    @Test
    public void testSorterStudents(){
        Student student1 = new Student("Alicia", "alicia@mail");
        Student student2 = new Student("Marisa", "Marisa@mail");
        Student student3 = new Student("Abril", "abril@mail");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        Sorter<Student> newSorter = new Sorter<>(students, Comparator.comparing(Student::getName));

        assertEquals("Abril", newSorter.getOrderedList().getFirst().getName());
        assertEquals("Alicia", newSorter.getOrderedList().get(1).getName());
        assertEquals("Marisa", newSorter.getOrderedList().get(2).getName());
    }

}
