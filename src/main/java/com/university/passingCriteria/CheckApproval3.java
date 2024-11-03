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

public class CheckApproval3 {
    private Student student;
    private Course course;
    private List<Evaluation> evaluations;
    private String[] datum;
    public CheckApproval3(Student student, Course course, List<Evaluation> evaluations, String[] datum){
        this.student = student;
        this.course = course;
        this.evaluations = evaluations;
        this.datum = datum;
        criteria();

    }

    public void criteria(){
        int counter = 0;
        List<Float> tp = new ArrayList<>();
        List<Float> parcial = new ArrayList<>();
        for (Evaluation evaluation: evaluations){
            if (evaluation.getCourse().equals(course.getSubject())){
                if (counter < (Arrays.copyOfRange(datum,3, datum.length).length)) {
                    if (datum[3].equals("TP Final")){
                        if (evaluation.getEvaluationName().equals("TP Final")) {
                            MaxAboveValue check = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                            student.addReport(course.getSubject(), check.approved());
                        }
                        counter ++;
                    }
                    else if (datum[3].contains("TP")){
                        if (evaluation.getEvaluationName().contains("TP") && !evaluation.getEvaluationName().equals("TP Final")) {
                            tp.add(evaluation.getGrade());
                            if (counter == (Arrays.copyOfRange(datum, 3, datum.length).length - 1)) {
                                AverageAboveValue check = new AverageAboveValue(tp, Float.parseFloat(datum[2]));
                                student.addReport(course.getSubject(), check.approved());
                            }
                            counter++;
                        }
                    }
                    else if (datum[3].contains("Final")){
                        if (evaluation.getEvaluationName().contains("Final") && evaluation.getEvaluationName().equals("TP Final")) {
                            MaxAboveValue check = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                            student.addReport(course.getSubject(), check.approved());
                            counter++;
                        }
                    }
                    else if (datum[3].contains("Parcial")){
                        if (evaluation.getEvaluationName().contains("Parcial")) {
                            parcial.add(evaluation.getGrade());
                            if (counter == (Arrays.copyOfRange(datum, 3, datum.length).length - 1)) {
                                MinAboveValue check = new MinAboveValue(parcial, Float.parseFloat(datum[2]));
                                student.addReport(course.getSubject(), check.approved());
                            }
                            counter++;
                        }
                    }

                }
            }
        }
    }
}
