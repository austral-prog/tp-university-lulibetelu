package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.student.Student;

public class FinalExam extends Evaluation {
    public FinalExam(String evaluationType, String evaluationName){
        super(evaluationType, evaluationName);
    }
    @Override
    public float calculateGrade() {
        float sum = 0;
        for (Excercise excercise: excercises){
            sum += excercise.getGrade();
        }
        return sum;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) { Id = id; }
}
