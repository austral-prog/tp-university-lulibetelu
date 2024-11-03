package com.university.passingCriteriaTest;

import com.university.course.Course;
import com.university.evaluation.CreateEvaluation;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.passingCriteria.PassingCriteria;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCheckApproval {
    List<String[]> data = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        data.add(new String[]{"Geography", "MIN_ABOVE_VALUE", "6", "Primer Parcial", "Segundo Parcial", "Tercer Parcial"});

        Student student = new Student("Juan", "juan@mail");
        students.add(student);

        Course course = new Course("275","Geography", "Sam");
        students.getFirst().addSubject(course);
        course.addStudents(student);
        courses.add(course);
    }

    @Test
    public void testCheckApprovalPassed(){

        List<Evaluation> evaluations = new ArrayList<>();
        Evaluation parcial1 = new WrittenExam(students.getFirst(), courses.getFirst(), "WRITTEN_EXAM", "Primer Parcial");
        Excercise ej1 = new Excercise("Ej1", "7");
        parcial1.addExcercises(ej1);
        evaluations.add(parcial1);
        students.getFirst().addEvaluation(parcial1);

        Evaluation parcial2 = new WrittenExam(students.getFirst(), courses.getFirst(),"WRITTEN_EXAM", "Segundo Parcial");
        Excercise ej2 = new Excercise("Ej2", "8");
        parcial2.addExcercises(ej2);
        evaluations.add(parcial2);
        students.getFirst().addEvaluation(parcial2);

        Evaluation parcial3 = new WrittenExam(students.getFirst(), courses.getFirst(),"WRITTEN_EXAM", "Tercer Parcial");
        Excercise ej3 = new Excercise("Ej3", "9");
        parcial3.addExcercises(ej3);
        evaluations.add(parcial3);
        students.getFirst().addEvaluation(parcial3);

        PassingCriteria test1 = new PassingCriteria(students, data);
        assertFalse(students.getFirst().getReport().get(courses.getFirst().getSubject()).contains(false));
        assertEquals(1, students.getFirst().getReport().get(courses.getFirst().getSubject()).size());
        assertEquals(true, students.getFirst().getReport().get(courses.getFirst().getSubject()).getFirst());

        assertEquals("Geography,Juan,Aprobado", courses.getFirst().toStringForSolution());

    }
    @Test
    public void testCheckApprovalNotPassed(){
        List<Evaluation> evaluations = new ArrayList<>();
        Evaluation parcial1 = new WrittenExam(students.getFirst(), courses.getFirst(), "WRITTEN_EXAM", "Primer Parcial");
        Excercise ej1 = new Excercise("Ej1", "5");
        parcial1.addExcercises(ej1);
        evaluations.add(parcial1);
        students.getFirst().addEvaluation(parcial1);

        Evaluation parcial2 = new WrittenExam(students.getFirst(), courses.getFirst(),"WRITTEN_EXAM", "Segundo Parcial");
        Excercise ej2 = new Excercise("Ej2", "8");
        parcial2.addExcercises(ej2);
        evaluations.add(parcial2);
        students.getFirst().addEvaluation(parcial2);

        Evaluation parcial3 = new WrittenExam(students.getFirst(), courses.getFirst(),"WRITTEN_EXAM", "Tercer Parcial");
        Excercise ej3 = new Excercise("Ej3", "9");
        parcial3.addExcercises(ej3);
        evaluations.add(parcial3);
        students.getFirst().addEvaluation(parcial3);

        PassingCriteria test1 = new PassingCriteria(students, data);
        assertTrue(students.getFirst().getReport().get(courses.getFirst().getSubject()).contains(false));
        assertEquals(1, students.getFirst().getReport().get(courses.getFirst().getSubject()).size());
        assertEquals(false, students.getFirst().getReport().get(courses.getFirst().getSubject()).getFirst());

    }
}
