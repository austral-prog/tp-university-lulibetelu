package com.university.evaluationTest;

import com.university.course.Course;
import com.university.evaluation.CreateEvaluation;
import com.university.evaluation.Evaluation;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreateEval {
    private List<Course> courses = new ArrayList<>();
    List<String[]> data;
    List<Student> students;
    List<Evaluation> evaluations;



    @BeforeEach
    public void Setup(){

        Course course1 = new Course("578", "English", "Toby");
        Course course2 = new Course("111", "Geography", "Ted");
        Course course3 = new Course("712", "Sociology", "Sam");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }
    @Test
    public void testCreateEval(){
        data = new ArrayList<>();
        students = new ArrayList<>();
        evaluations = new ArrayList<>();

        data.add(new String[]{"Paul Beige","English","WRITTEN_EXAM","Segundo Parcial","Ej2","7"});
        data.add(new String[]{"Frank Pink","Geography","PRACTICAL_WORK","TP3","Ej3","3"});
        data.add(new String[]{"Charlie Davis","Sociology","ORAL_EXAM","Primer Parcial","Ej1","9"});

        Student student1 = new Student("Paul Beige", "paul@mail");
        Student student2 = new Student("Frank Pink", "frank@mail");
        Student student3 = new Student("Charlie Davis", "charlie@mail");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        CreateEvaluation createEvaluation = new CreateEvaluation(data, courses, students);
        evaluations = createEvaluation.getEvaluations();

        assertEquals(3, evaluations.size());
        assertEquals("Paul Beige", evaluations.getFirst().getStudent());
        assertEquals("English", evaluations.getFirst().getCourse());
        assertEquals("WRITTEN_EXAM", evaluations.getFirst().getEvaluationType());
        assertEquals("Segundo Parcial", evaluations.getFirst().getEvaluationName());
        assertEquals("Ej2", evaluations.getFirst().getExcercises().getFirst().getName());
        assertEquals(7, evaluations.getFirst().getExcercises().getFirst().getGrade());

        assertEquals("Frank Pink", evaluations.get(1).getStudent());
        assertEquals("Geography", evaluations.get(1).getCourse());
        assertEquals("PRACTICAL_WORK", evaluations.get(1).getEvaluationType());
        assertEquals("TP3", evaluations.get(1).getEvaluationName());
        assertEquals("Ej3", evaluations.get(1).getExcercises().getFirst().getName());
        assertEquals(3, evaluations.get(1).getExcercises().getFirst().getGrade());

        assertEquals("Charlie Davis", evaluations.get(2).getStudent());
        assertEquals("Sociology", evaluations.get(2).getCourse());
        assertEquals("ORAL_EXAM", evaluations.get(2).getEvaluationType());
        assertEquals("Primer Parcial", evaluations.get(2).getEvaluationName());
        assertEquals("Ej1", evaluations.get(2).getExcercises().getFirst().getName());
        assertEquals(9, evaluations.get(2).getExcercises().getFirst().getGrade());

        assertEquals(1, courses.getFirst().getEvaluations().size());

    }
    @Test
    public void testDuplicatedEval(){
        List<String[]> data = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Evaluation> evaluations = new ArrayList<>();

        data.add(new String[]{"Paul Beige","English","WRITTEN_EXAM","Segundo Parcial","Ej2","7"});
        data.add(new String[]{"Frank Pink","Geography","PRACTICAL_WORK","TP3","Ej3","3"});
        data.add(new String[]{"Frank Pink","Geography","PRACTICAL_WORK","TP3","Ej3","3"});

        Student student1 = new Student("Paul Beige", "paul@mail");
        Student student2 = new Student("Frank Pink", "frank@mail");
        students.add(student1);
        students.add(student2);

        CreateEvaluation createEvaluation = new CreateEvaluation(data, courses, students);
        evaluations = createEvaluation.getEvaluations();

        assertEquals(2, evaluations.size());


    }
}
