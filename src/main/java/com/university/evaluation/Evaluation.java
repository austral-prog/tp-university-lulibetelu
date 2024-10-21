package com.university.evaluation;

import com.university.Printable;
import com.university.course.Course;
import com.university.student.Student;

import javax.security.auth.Subject;

public class Evaluation implements Printable {
    private String evaluationType;
    private String evaluationName;
    private String excerciseName;
    private String grade;
    private Course course;
    private Student student;
    public Evaluation(Student student, Course course, String evaluationType, String evaluationName, String excerciseName, String grade){
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.excerciseName = excerciseName;
        this.grade = grade;
        this.course = course;
        this.student = student;
    }
    public String getEvaluationType(){
        return evaluationType;
    }
    public String getEvaluationName(){
        return evaluationName;
    }
    public String getExcerciseName(){
        return excerciseName;
    }
    public String getGrade(){
        return grade;
    }
    public Course getCourse() {
        return course;
    }
    public Student getStudent(){
        return student;
    }

    @Override
    public String toStringForSolution() {
        return course.getSubject() + "," + evaluationName + "," + student.getName() + "," ;
    }

    @Override
    public int compareTo(Object o) {
        Evaluation evaluation = (Evaluation) o;
        return evaluationName.compareTo(evaluation.getEvaluationName());
    }
}
