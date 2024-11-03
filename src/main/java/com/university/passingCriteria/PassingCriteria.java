package com.university.passingCriteria;

import com.university.course.Course;
import com.university.student.Student;

import java.util.List;
import java.util.Map;

public class PassingCriteria {
    private List<Student> students;
    private List<String[]> data3;
    public PassingCriteria(List<Student> students, List<String[]> data3){
        this.students = students;
        this.data3 = data3;
        mark();
        checkIfAllExamsTaken();
    }
    public void mark(){
        CheckApproval checkApproval = new CheckApproval();
        for (Student student: students){
            for (String[] datum: data3){
                for (Course course: student.getSubjects()){
                    if (course.getSubject().equals(datum[0])){
                        checkApproval.criteria(student, course, datum);

                    }
                }
            }
        }
    }
    public void checkIfAllExamsTaken(){
        for (Student student: students){
            for (Course course: student.getSubjects()) {
                if (!student.getReport().keySet().contains(course.getSubject())){
                    student.addReport(course.getSubject(), false);
                }

            }
        }
    }
}


