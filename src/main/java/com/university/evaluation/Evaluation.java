package com.university.evaluation;

import com.university.Printable;
import com.university.course.Course;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Evaluation implements Printable {
    private String student;
    private String course;
    private String evaluationType;
    private String evaluationName;

    private List<Excercise> excercises;
    public Evaluation(Student student, Course course, String evaluationType, String evaluationName){
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

    public String getGrade() {
        return calculateGrade();
    }

    public String calculateGrade() {
        int total = 0;
        int counter = 0;
        if (!excercises.isEmpty()) {
            for (Excercise excercise : excercises) {
                total += Integer.parseInt(excercise.getGrade());
                counter++;
            }
        }
        return String.valueOf((float)(total / counter));
    }

    @Override
    public String toStringForSolution() {
        return course + "," + evaluationName + "," + student + "," + calculateGrade();
    }

    @Override
    public int compareTo(Object o) {
        Evaluation evaluation = (Evaluation) o;
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
