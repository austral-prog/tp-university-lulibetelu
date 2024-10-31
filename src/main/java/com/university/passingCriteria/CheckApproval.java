package com.university.passingCriteria;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.passingCriteria.criteria.AverageAboveValue;
import com.university.passingCriteria.criteria.MaxAboveValue;
import com.university.passingCriteria.criteria.MinAboveValue;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckApproval {
    private Student student;
    private Course course;
    private List<Evaluation> evaluations;
    private String[] datum;
    private Float criteria;
    public CheckApproval(Student student, Course course, List<Evaluation> evaluations, String[] datum){
        this.student = student;
        this.course = course;
        this.evaluations = evaluations;
        this.datum = datum;

    }

    public void criteria(){
        for (Evaluation evaluation: evaluations){
            if (evaluation.getCourse().equals(course.getSubject())){
                List<Float> tp = new ArrayList<>();
                int counter = 0;
                while (counter < (Arrays.copyOfRange(datum,3, datum.length).length)) {
                    if (datum[3].contains("TP")){
                        tp.add(evaluation.getGrade());
                        if (counter == (Arrays.copyOfRange(datum,3, datum.length).length-1)) {
                            AverageAboveValue check = new AverageAboveValue(tp, (Arrays.copyOfRange(datum,3, datum.length).length));
                            student.addReport(course.getSubject(), check.approved());
                        }
                        counter++;
                    }
                    else if (datum[3].contains("Final")){
                        MaxAboveValue check = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                        student.addReport(course.getSubject(), check.approved());
                        counter ++;
                    }
                    else if (datum[3].contains("Parcial")){
                        MinAboveValue check = new MinAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                        student.addReport(course.getSubject(), check.approved());
                        counter++;
                    }

                }
            }
        }
    }
}
