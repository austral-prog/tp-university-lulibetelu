package com.university.appTest;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.evaluation.typesOfEval.OralExam;
import com.university.evaluation.typesOfEval.PracticalWork;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.sortable.Sorter;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSorter {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Evaluation> evaluations = new ArrayList<>();

    @BeforeEach
    public void Setup(){
        Student student1 = new Student("Alicia", "alicia@mail");
        Student student2 = new Student("Marisa", "Marisa@mail");
        Student student3 = new Student("Abril", "abril@mail");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        Course course1 = new Course("578", "Art", "Toby");
        Course course2 = new Course("111", "Biology", "Ted");
        Course course3 = new Course("712", "Art", "Sam");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

    }
    @Test
    public void testSorterStudents(){

        Sorter<Student> newSorter = new Sorter<>(students, Comparator.comparing(Student::getName));

        assertEquals("Abril", newSorter.getOrderedList().getFirst().getName());
        assertEquals("Alicia", newSorter.getOrderedList().get(1).getName());
        assertEquals("Marisa", newSorter.getOrderedList().get(2).getName());
    }
    @Test
    public void testSorterEvaluations(){

        Evaluation eval1 = new WrittenExam(students.getFirst(), courses.getFirst(), "Written", "Final");
        evaluations.add(eval1);
        Evaluation eval2 = new PracticalWork(students.get(1), courses.get(1), "Practical", "TP");
        evaluations.add(eval2);
        Evaluation eval3 = new OralExam(students.get(2), courses.get(2), "Oral", "Exam");
        evaluations.add(eval3);

        Excercise e1 = new Excercise("Ej2", "5");
        Excercise e2 = new Excercise("E1", "7");
        eval3.addExcercises(e1);
        eval3.addExcercises(e2);

        Excercise e3 = new Excercise("Ej2", "8");
        Excercise e4 = new Excercise("Ej1", "9");
        eval2.addExcercises(e3);
        eval2.addExcercises(e4);

        Excercise e5 = new Excercise("Ej1", "4");
        Excercise e6 = new Excercise("Ej2", "3");
        eval1.addExcercises(e5);
        eval1.addExcercises(e6);

        Sorter<Evaluation> newSorter = new Sorter<>(evaluations, Comparator.comparing(Evaluation:: getCourse)
                .thenComparing(Evaluation::getEvaluationName));

        assertEquals("Art", newSorter.getOrderedList().getFirst().getCourse());
        assertEquals("Exam", newSorter.getOrderedList().getFirst().getEvaluationName());
        assertEquals("Abril", newSorter.getOrderedList().getFirst().getStudent());

        assertEquals("Art", newSorter.getOrderedList().get(1).getCourse());
        assertEquals("Final", newSorter.getOrderedList().get(1).getEvaluationName());
        assertEquals("Alicia", newSorter.getOrderedList().get(1).getStudent());

        assertEquals("Biology", newSorter.getOrderedList().get(2).getCourse());
        assertEquals("TP", newSorter.getOrderedList().get(2).getEvaluationName());
        assertEquals("Marisa", newSorter.getOrderedList().get(2).getStudent());


    }

}
