package com.university.passingCriteria;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

import java.util.List;

//public class PassingCriteria {
//    private List<Student> students;
//    private List<String[]> data3;
//    public PassingCriteria(List<String[]> data3, List<Student> students, List<Evaluation> evaluations){
//        this.students = students;
//        this.data3 = data3;
//    }
//    public void mark(){
//        for (Student student: students){
//            for (String[] datum: data3){
//                for (Course course: student.getSubjects()){
//                    if (course.getSubject().equals(datum[0])){
//                        if (datum[3].equals("TP Final")) {
//                            for (Evaluation evaluation : student.getEvaluations().get("TP")) {
//                                MaxAboveValue criteria1 = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
//                                student.addReport(course.getSubject(), criteria1.approved());
//                            }
//
//                        } else if (datum[3].contains("TP")) {
//
//
//                        } else if (datum[3].contains("Parcial")) {
//                            for (Evaluation evaluation : student.getEvaluations().get("Parcial")) {
//                                MinAboveValue criteria3 = new MinAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
//                                student.addReport(course.getSubject(), criteria3.approved());
//                            }
//
//                        } else {
//                            for (Evaluation evaluation : student.getEvaluations().get("Examen")) {
//                                MaxAboveValue criteria4 = new MaxAboveValue(evaluation.getGrade(), Float.parseFloat(datum[2]));
//                                student.addReport(course.getSubject(), criteria4.approved());
//                            }
//
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//}
//
//
