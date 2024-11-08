package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

public class OralExam extends Evaluation {
    public OralExam(String evaluationType, String evaluationName){
        super(evaluationType, evaluationName);
    }
    @Override
    public float calculateGrade() {
        return excercises.getFirst().getGrade();
    }

    @Override
    public int getId() { return Id; }

    @Override
    public void setId(int id) { Id = id; }
}
