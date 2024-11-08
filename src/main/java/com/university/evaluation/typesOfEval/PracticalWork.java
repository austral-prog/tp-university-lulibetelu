package com.university.evaluation.typesOfEval;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.Excercise;
import com.university.student.Student;

public class PracticalWork extends Evaluation {
    public PracticalWork(String evaluationType, String evaluationName){
        super(evaluationType, evaluationName);
    }

    @Override
    public float calculateGrade() {
        return excercises.getLast().getGrade();
//        float lastEj = 0;
////        for (Excercise excercise : excercises) {
////            if (Float.parseFloat(excercise.getName().substring(2)) > lastEj) {
////                lastEj = Float.parseFloat(excercise.getName().substring(2));
////            }
////        }
////        float grade = 0;
//////        for (Excercise excercise : excercises) {
//////            if (Float.parseFloat(excercise.getName().substring(2)) == lastEj) {
//////                grade = excercise.getGrade();
//////            }
//////        }
    }

    @Override
    public int getId() { return Id; }

    @Override
    public void setId(int id) { Id = id;}
}
