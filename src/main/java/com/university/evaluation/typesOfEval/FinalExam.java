package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.student.Student;

public class FinalExam extends Evaluation {
    public FinalExam(Student student, Course course, String evaluationType, String evaluationName){
        super(student, course, evaluationType, evaluationName);
    }
    @Override
    public float calculateGrade() {
        float sum = 0;
        for (Excercise excercise: excercises){
            sum += excercise.getGrade();
        }
        return sum;
    }
}