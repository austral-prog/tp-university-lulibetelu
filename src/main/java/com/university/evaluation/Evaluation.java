package com.university.evaluation;

import com.university.cli.entities.Entity;
import com.university.Formattable;
import com.university.course.Course;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluation implements Formattable<Evaluation>, Entity {
    protected String student;
    protected String course;
    protected String evaluationType;
    protected String evaluationName;
    protected List<Excercise> excercises;
    protected int Id;

    public Evaluation(String evaluationType, String evaluationName) {
        this.student = "";
        this.course = "";
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.excercises = new ArrayList<>();
        this.Id = 0;
    }
    public String getEvaluationType(){
        return evaluationType;
    }

    public String getEvaluationName(){
        return evaluationName;
    }

    public List<Excercise> getExcercises(){
        return excercises;
    }

    public String getCourse() {
        return course;
    }

    public String getStudent(){
        return student;
    }

    public void addExcercises(Excercise excercise){
        excercises.add(excercise);
    }

    public float getGrade(){
        return calculateGrade();
    }

    public abstract float calculateGrade();

    public void setStudent(Student newStudent){
        student = newStudent.getName();
    }

    public void setCourse(Course newCourse){
        course = newCourse.getSubject();
    }

    @Override
    public String[] toStringForSolution() {
        String[] strings = {course + "," + evaluationName + "," + student + "," +  getGrade()};
        return strings;
    }

    @Override
    public int compareTo(Evaluation evaluation) {
        if (!this.getCourse().equals(evaluation.getCourse())) {
            return this.getCourse().compareTo(evaluation.getCourse());
        }
        else if (!evaluationName.equals(evaluation.getEvaluationName())){
            return evaluationName.compareTo(evaluation.getEvaluationName());
        }
        else{
            return student.compareTo(evaluation.getStudent());
        }
    }


}
