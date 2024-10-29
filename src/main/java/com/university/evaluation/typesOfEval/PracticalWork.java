package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.student.Student;

public class PracticalWork extends Evaluation {
    public PracticalWork(Student student, Course course, String evaluationType, String evaluationName){
        super(student, course, evaluationType, evaluationName);
    }


    @Override
    public float calculateGrade() {
        float lastEj = 0;
        for (Excercise excercise : excercises) {
            if (Float.parseFloat(excercise.getName().substring(2)) > lastEj) {
                lastEj = Float.parseFloat(excercise.getName().substring(2));
            }
        }
        float grade = 0;
        for (Excercise excercise : excercises) {
            if (Float.parseFloat(excercise.getName().substring(2)) == lastEj) {
                grade = excercise.getGrade();
            }
        }
        return grade;
    }
}
