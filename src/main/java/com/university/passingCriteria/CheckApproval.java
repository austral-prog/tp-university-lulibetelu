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
    public void criteria(Student student, Course course, String[] datum){
        List<Float> tp = new ArrayList<>();
        List<Float> parciales = new ArrayList<>();
        for (Evaluation evaluation: student.getEvaluations()){
            if (datum[3].equals("TP Final")){
                if (evaluation.getEvaluationName().equals("TP Final") && evaluation.getCourse().equals(course.getSubject())){
                    MaxAboveValue check = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                    student.addReport(course.getSubject(), check.approved());
                    }
                }

            else if (datum[3].contains("TP")){
                if (evaluation.getEvaluationName().contains("TP")
                        && !evaluation.getEvaluationName().equals("TP Final")
                        && evaluation.getCourse().equals(course.getSubject())){
                    tp.add(evaluation.getGrade());
                    if (tp.size() == (Arrays.copyOfRange(datum, 3, datum.length).length)){
                        AverageAboveValue check = new AverageAboveValue(tp, Float.parseFloat(datum[2]));
                        student.addReport(course.getSubject(), check.approved());
                    }

                }
            }
            else if (datum[3].contains("Final")){
                if (evaluation.getEvaluationName().contains("Final") && evaluation.getCourse().equals(course.getSubject())){
                    MaxAboveValue check = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
                    student.addReport(course.getSubject(), check.approved());
                }
            }
            else if (datum[3].contains("Parcial")){
                if (evaluation.getEvaluationName().contains("Parcial") && evaluation.getCourse().equals(course.getSubject())){
                    parciales.add(evaluation.getGrade());
                    if (parciales.size() == (Arrays.copyOfRange(datum, 3, datum.length)).length){
                        MinAboveValue check = new MinAboveValue(parciales, Float.parseFloat(datum[2]));
                        student.addReport(course.getSubject(), check.approved());
                    }
                }
            }
        }

    }
}
