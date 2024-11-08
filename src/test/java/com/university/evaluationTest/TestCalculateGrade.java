package com.university.evaluationTest;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.evaluation.typesOfEval.FinalExam;
import com.university.evaluation.typesOfEval.OralExam;
import com.university.evaluation.typesOfEval.PracticalWork;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.student.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculateGrade {
    private Course course = new Course("578", "English", "Toby");
    private Student student = new Student("Juan","juan@mail");

    @Test
    public void testGradeFinal(){
        Evaluation eval1 = new FinalExam("FINAL_PRACTICAL_WORK", "TP Final");
        eval1.setStudent(student);
        eval1.setCourse(course);

        Excercise e1 = new Excercise("Ej1","7");
        eval1.addExcercises(e1);
        Excercise e2 = new Excercise("Ej2","0");
        eval1.addExcercises(e2);
        Excercise e3 = new Excercise("Ej3","1");
        eval1.addExcercises(e3);

        assertEquals(8, eval1.getGrade());
    }
    @Test
    public void testGradeOral(){
        Evaluation eval2 = new OralExam("ORAL_EXAM","Primer Parcial");
        eval2.setStudent(student);
        eval2.setCourse(course);
        Excercise e = new Excercise("Ej1","1");
        eval2.addExcercises(e);

        assertEquals(1, eval2.getGrade());
    }
    @Test
    public void testGradePractical(){
        Evaluation eval3 = new PracticalWork("PRACTICAL_WORK","TP1");
        eval3.setStudent(student);
        eval3.setCourse(course);
        Excercise e1 = new Excercise("Ej1","4");
        Excercise e2 = new Excercise("Ej2","7");
        Excercise e3 = new Excercise("Ej3","9");

        eval3.addExcercises(e1);
        eval3.addExcercises(e2);
        eval3.addExcercises(e3);

        assertEquals(9, eval3.getGrade());
    }
    @Test
    public void testGradeWritten(){
        Evaluation eval4 = new WrittenExam("WRITTEN_EXAM","Segundo Parcial");
        eval4.setStudent(student);
        eval4.setCourse(course);
        Excercise e1 = new Excercise("Ej1","7");
        Excercise e2 = new Excercise("Ej2","8");
        Excercise e3 = new Excercise("Ej3","5");
        Excercise e4 = new Excercise("Ej 4", "4");

        eval4.addExcercises(e1);
        eval4.addExcercises(e2);
        eval4.addExcercises(e3);
        eval4.addExcercises(e4);

        assertEquals(6, eval4.getGrade());
    }
}

