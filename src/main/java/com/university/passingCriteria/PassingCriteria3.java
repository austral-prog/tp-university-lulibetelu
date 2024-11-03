package com.university.passingCriteria;

import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

import java.util.List;
import java.util.Map;

public class PassingCriteria3 {
    private List<Student> students;
    private List<String[]> data3;
    public PassingCriteria3(List<String[]> data3, List<Student> students, List<Evaluation> evaluations){
        this.students = students;
        this.data3 = data3;
        checkIfAllExamsTaken();
    }
    public void mark(){
        for (Student student: students){  //agarro el primer estudiante
            for (String[] datum: data3){
                for (Course course: student.getSubjects()){
                    if (course.getSubject().equals(datum[0])){  // me fijo si el estudiante cursa la materia de la linea en la que estoy
//                        CheckApproval checkApproval = new CheckApproval(student, course, student.getEvaluations(), datum);
                    }
                }

            }
        }
    }
    public void checkIfAllExamsTaken(){
        for (Student student: students){
            for (Map.Entry<String, List<Boolean>> entry: student.getReport().entrySet()){
                if (!(student.getSubjects().size() == entry.getValue().size())){
                    entry.getValue().add(false);
                }
            }
        }
    }
}

