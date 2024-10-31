package com.university.passingCriteria;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

import java.util.Arrays;
import java.util.List;

public class PassingCriteria {
    private List<Student> students;
    private List<String[]> data3;
    public PassingCriteria(List<String[]> data3, List<Student> students, List<Evaluation> evaluations){
        this.students = students;
        this.data3 = data3;
    }
    public void mark(){
        for (Student student: students){  //agarro el primer estudiante
            for (String[] datum: data3){
                for (Course course: student.getSubjects()){
                    if (course.getSubject().equals(datum[0])){  // me fijo si el estudiante cursa la materia de la linea en la que estoy
                        CheckApproval checkApproval = new CheckApproval(student, course, student.getEvaluations(), datum);
                    }
                }

            }
        }
    }
}

