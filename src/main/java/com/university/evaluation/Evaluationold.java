package com.university.evaluation;

import com.university.Printable;
import com.university.course.Course;
import com.university.student.Student;

import java.util.List;

public class Evaluationold implements Printable {
    private String evaluationType;
    private String evaluationName;
    private List<String> excercises;
    private List<String> grades;
    private Course course;
    private Student student;
    public Evaluationold(Student student, Course course, String evaluationType, String evaluationName, List<String> excercises, List<String> grades){
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.excercises = excercises;
        this.grades = grades;
        this.course = course;
        this.student = student;
    }
    public String getEvaluationType(){
        return evaluationType;
    }
    public String getEvaluationName(){
        return evaluationName;
    }
    public List<String> getExcercises(){
        return excercises;
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
        Evaluationold evaluation = (Evaluationold) o;
        return evaluationName.compareTo(evaluation.getEvaluationName());
    }
}
