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
        List<Float> tpFinal = new ArrayList<>();
        List<Float> finales = new ArrayList<>();
        MaxAboveValue check1 = new MaxAboveValue();
        AverageAboveValue check2 = new AverageAboveValue();
        MinAboveValue check3 = new MinAboveValue();


        for (Evaluation evaluation: student.getEvaluations()){
            if (datum[3].equals("TP Final")){
                if (evaluation.getEvaluationName().equals("TP Final") && evaluation.getCourse().equals(course.getSubject())){
                    tpFinal.add(evaluation.getGrade());  // cada evaluacion del tipo TP Final solo tiene un examen
                    student.addReport(course.getSubject(), check1.approved(tpFinal, Float.parseFloat(datum[2])));
                    }
                }

            else if (datum[3].contains("TP")){
                if (evaluation.getEvaluationName().contains("TP")
                        && !evaluation.getEvaluationName().equals("TP Final")
                        && evaluation.getCourse().equals(course.getSubject())){
                    tp.add(evaluation.getGrade());
                    if (tp.size() == (Arrays.copyOfRange(datum, 3, datum.length).length)){
                        student.addReport(course.getSubject(), check2.approved(tp, Float.parseFloat(datum[2])));
                    }

                }
            }
            else if (datum[3].contains("Final")){
                if (evaluation.getEvaluationName().contains("Final") && evaluation.getCourse().equals(course.getSubject())){
                    finales.add(evaluation.getGrade()); // cada evaluacion del tipo Final solo tiene un examen
                    student.addReport(course.getSubject(), check1.approved(finales, Float.parseFloat(datum[2])));
                }
            }
            else if (datum[3].contains("Parcial")){
                if (evaluation.getEvaluationName().contains("Parcial") && evaluation.getCourse().equals(course.getSubject())){
                    parciales.add(evaluation.getGrade());
                    if (parciales.size() == (Arrays.copyOfRange(datum, 3, datum.length)).length){
                        student.addReport(course.getSubject(), check3.approved(parciales, Float.parseFloat(datum[2])));
                    }
                }
            }
        }

    }
}
