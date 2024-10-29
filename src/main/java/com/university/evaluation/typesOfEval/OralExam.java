package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

public class OralExam extends Evaluation {
    public OralExam(Student student, Course course, String evaluationType, String evaluationName){
        super(student, course, evaluationType, evaluationName);
    }
    @Override
    public float calculateGrade() {
        return excercises.getFirst().getGrade();
    }
}
