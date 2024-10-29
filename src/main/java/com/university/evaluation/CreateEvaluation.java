package com.university.evaluation;

import com.university.course.Course;
import com.university.evaluation.typesOfEval.FinalExam;
import com.university.evaluation.typesOfEval.OralExam;
import com.university.evaluation.typesOfEval.PracticalWork;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.student.Student;

import java.util.ArrayList;
import java.util.List;

public class CreateEvaluation {
    private List<Evaluation> evaluations;
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
                && evaluations.get(count).getCourse().equals(datum[1])
                && evaluations.get(count).getStudent().equals(datum[0])) {
                    found = true;
                    Excercise excercise = new Excercise(datum[4], datum[5]);
                    evaluations.get(count).addExcercises(excercise);
                    break;
                }
                count++;

            }
            if (!found) {
                for (Course course: courses) {
                    if (course.getSubject().equals(datum[1])) {
                        for (Student student: students) {
                            if (student.getName().equals(datum[0])) {
                                Excercise excercise = new Excercise(datum[4], datum[5]);

                                if (datum[2].contains("FINAL")){
                                  Evaluation eval = new FinalExam(student, course, datum[2], datum[3]);
                                  student.addEvaluation(eval);
                                  evaluations.add(eval);
                                  eval.addExcercises(excercise);
                                  course.addEval(eval);

                                }
                                else if (datum[2].equals("ORAL_EXAM")){
                                    Evaluation eval = new OralExam(student, course, datum[2], datum[3]);
                                    student.addEvaluation(eval);
                                    evaluations.add(eval);
                                    eval.addExcercises(excercise);
                                    course.addEval(eval);
                                }
                                else if (datum[2].equals("PRACTICAL_WORK")){
                                    Evaluation eval = new PracticalWork(student, course, datum[2], datum[3]);
                                    student.addEvaluation(eval);
                                    evaluations.add(eval);
                                    eval.addExcercises(excercise);
                                    course.addEval(eval);
                                }
                                else if (datum[2].equals("WRITTEN_EXAM")){
                                    Evaluation eval = new WrittenExam(student, course, datum[2], datum[3]);
                                    student.addEvaluation(eval);
                                    evaluations.add(eval);
                                    eval.addExcercises(excercise);
                                    course.addEval(eval);
                                }

                            }
                        }
                    }
                }
            }
        }

    }

    public List<Evaluation> getEvaluations(){
        return evaluations;
    }

}


