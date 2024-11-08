package com.university.cliTest;

import com.university.cli.entities.CrudEvaluation;
import com.university.cli.entities.CrudStudent;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCrudEvaluation {
    private CrudEvaluation crudEvaluation;
    @BeforeEach
    public void setUp(){
        crudEvaluation = new CrudEvaluation();
    }
    @Test
    public void testCreate(){
        Evaluation evaluation = new WrittenExam("Written Exam", "Exam");
        evaluation.setId(1);
        crudEvaluation.create(evaluation);
        assertTrue(crudEvaluation.getMap().containsKey(1));
        assertEquals(evaluation, crudEvaluation.getMap().get(1));
    }
    @Test
    public void testRead(){
        Evaluation evaluation = new WrittenExam("Written Exam", "Exam");
        evaluation.setId(2);
        crudEvaluation.create(evaluation);
        assertEquals(evaluation, crudEvaluation.read(evaluation.getId()));
    }
    @Test
    public void testUpdate(){
        Evaluation evaluation = new WrittenExam("Written Exam", "Exam");
        evaluation.setId(3);
        crudEvaluation.create(evaluation);
        Evaluation evaluation1 = new WrittenExam("Written Exam", "dj");
        crudEvaluation.update(3, evaluation1);
        assertEquals(evaluation1, crudEvaluation.getMap().get(3));


    }
    @Test
    public void testDelete(){
        Evaluation evaluation = new WrittenExam("Written Exam", "Exam");
        evaluation.setId(4);
        crudEvaluation.create(evaluation);
        crudEvaluation.delete(4);
        assertFalse(crudEvaluation.getMap().containsKey(4));
    }
    @Test
    public void testGetters(){
        Evaluation evaluation = new WrittenExam("Written Exam", "Exam");
        evaluation.setId(5);
        crudEvaluation.create(evaluation);
        assertEquals("Evaluation", crudEvaluation.getIdentifier());
        assertEquals(Evaluation.class, crudEvaluation.getEntityClass());
    }
}
