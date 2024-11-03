package com.university.course;

import com.university.Formattable;
import com.university.evaluation.Evaluation;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course implements Formattable<Course> {
    private String subject;
    private String classroom;
    private String teacher;
    private List<Student> students;
    private List<Evaluation> evaluations;

    public Course(String classroom, String subject , String teacher){
        this.subject = subject;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.evaluations = new ArrayList<>();
    }
    public String getSubject() { return subject; }

    public String getClassroom() { return classroom; }

    public String getTeacher() { return teacher; }

    public List<Student> getStudents() { return students; }

    public List<Evaluation> getEvaluations(){ return evaluations; }

    public void addStudents(Student student){ students.add(student); }

    public void addEval(Evaluation evaluation){ evaluations.add(evaluation); }


    @Override
    public String[] toStringForSolution(){

        String[] strings = new String[students.size()];
        for (Student student : students) {
            String message = "";
            for (Map.Entry<String, List<Boolean>> entry : student.getReport().entrySet()) {
                if (entry.getKey().equals(subject)) {
                    if (entry.getValue().contains(false)) {
                        message = entry.getKey() + "," + student.getName() + "," + "Desaprobado";
                    }
                    else {
                        message =  entry.getKey() + "," + student.getName() + "," + "Aprobado";
                    }
                }
            }
            strings[students.indexOf(student)]= message;

        }
        return strings;
    }


    @Override
    public int compareTo(Course course) {
        return subject.compareTo(course.getSubject());
        }

}
