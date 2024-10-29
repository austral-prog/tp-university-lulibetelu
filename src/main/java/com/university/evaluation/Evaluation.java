package com.university.evaluation;

import com.university.Formattable;
import com.university.course.Course;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluation implements Formattable<Evaluation> {
    protected String student;
    protected String course;
    protected String evaluationType;
    protected String evaluationName;
    protected List<Excercise> excercises;

    public Evaluation(Student student, Course course, String evaluationType, String evaluationName) {
        this.student = student.getName();
        this.course = course.getSubject();
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;

        this.excercises = new ArrayList<>();
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

    @Override
    public String toStringForSolution() {
        return course + "," + evaluationName + "," + student + "," +  getGrade();
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
