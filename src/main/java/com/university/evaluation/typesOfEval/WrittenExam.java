package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.student.Student;

public class WrittenExam extends Evaluation {
    public WrittenExam(Student student, Course course, String evaluationType, String evaluationName){
        super(student, course, evaluationType, evaluationName);
    }
    @Override
    public float calculateGrade() {
        float sum = 0;
        int counter = 0;
        for (Excercise excercise: excercises){
            sum += excercise.getGrade();
            counter++;
        }
        return sum/counter;
    }
}