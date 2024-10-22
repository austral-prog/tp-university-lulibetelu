package com.university.evaluation;

import com.university.course.Course;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public class CreateEvaluation {
    private List<Evaluationold> evaluations;
    public CreateEvaluation(List<String[]> data, List<Course> courses, List<Student> students){
        this.evaluations = new ArrayList<>();
        createEvaluations(data, courses, students);
    }
    public void createEvaluations(List<String[]> data2, List<Course> courses, List<Student> students){
        for (String[] datum : data2) {  // recorro las listas
            int count = 0;
            boolean found = false;
            while (count < evaluations.size()) {
                if (evaluations.get(count).getEvaluationType().equals(datum[2])
                && evaluations.get(count).getEvaluationName().equals(datum[3])
                && evaluations.get(count).getCourse().getSubject().equals(datum[1])) {
                    found = true;
                    break;
                }
                count++;
            }
            if (!found) {
                for (Course course: courses) {
                    if (course.getSubject().equals(datum[1])) {
                        for (Student student: students) {
                            if (student.getName().equals(datum[0])) {
                                Evaluationold evaluation = new Evaluationold(student, course, datum[2], datum[3], datum[4], datum[5]);
                                evaluations.add(evaluation);
                            }
                        }
                    }
                }
            }
        }

    }

    public List<Evaluationold> getEvaluations(){
        return evaluations;
    }

}


