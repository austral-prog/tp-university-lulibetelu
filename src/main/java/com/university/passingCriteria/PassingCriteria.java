package com.university.passingCriteria;

import com.university.course.Course;
import com.university.student.Student;

import java.util.List;
import java.util.Map;

public class PassingCriteria {
    public void mark(List<Student> students, List<String[]> data3){
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
    public void checkIfAllExamsTaken(List<Student> students){
        for (Student student: students){
            for (Course course: student.getSubjects()) {
                if (!student.getReport().containsKey(course.getSubject())){
                    student.addReport(course.getSubject(), false);
                }

            }
        }
    }
}


