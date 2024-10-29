package com.university.student;

import com.university.Formattable;
import com.university.course.Course;
import com.university.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Student implements Formattable<Student> {
    private String name;
    private String email;
    private List<Course> subjects;
    private List<Evaluation> evaluations;

    private HashMap<String, List<Boolean>> report;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
        this.subjects = new ArrayList<>();
        this.report = new HashMap<>();
        this.evaluations = new ArrayList<>();
    }

    public String getName() { return name; }

    public String getEmail(){
        return email;
    }

    public List<Course> getSubjects() {
        return subjects;
    }

    public List<Evaluation> getEvaluations() { return evaluations; }

    public HashMap<String, List<Boolean>> getReport(){ return report; }

    public void addSubject(Course course){
        subjects.add(course);
    }

    public void addEvaluation(Evaluation eval){
        evaluations.add(eval);
    }

    public int courseCount(){ return subjects.size(); }


    public void addReport(String course, Boolean x){
        if (report.containsKey(course)){
            report.get(course).add(x);
        }
        else{
            report.put(course, new ArrayList<>(Arrays.asList(x)));
        }
    }


    @Override
    public String toStringForSolution() { return name + "," + subjects.size(); }

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.getName());
        }
}

