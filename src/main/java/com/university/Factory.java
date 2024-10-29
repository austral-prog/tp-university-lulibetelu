package com.university;

import com.university.course.Course;
import com.university.course.CreateCourses;
import com.university.course.StudentsPerCourse;
import com.university.csvFile.WriteCsv;
import com.university.evaluation.CreateEvaluation;
import com.university.evaluation.Evaluation;
import com.university.sortable.Sorter;
import com.university.student.CoursesPerStudent;
import com.university.student.CreateStudent;
import com.university.student.Student;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static List<Evaluation> evaluations = new ArrayList<>();
    static List<Student> orderedStudents = new ArrayList<>();
    private List<String[]> data;
    private List<String[]> data2;
    private List<String[]> data3;

    public Factory(List<String[]> data, List<String[]> data2, List<String[]> data3){
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
        createObjects();
        createReports();

    }

    public void createObjects(){
        CreateCourses createCourses = new CreateCourses(data);
        courses = createCourses.getCourses();

        CreateStudent createStudent = new CreateStudent(data);
        students = createStudent.getStudents();

        CreateEvaluation evaluation = new CreateEvaluation(data2, courses, students);
        evaluations = evaluation.getEvaluations();

        StudentsPerCourse studentsPerCourse = new StudentsPerCourse(data, students, courses);
        CoursesPerStudent coursesPerStudent = new CoursesPerStudent(data, students, courses);
    }



    public void createReports(){
        Sorter<Student> newSorter = new Sorter<>(students, Comparator.comparing(Student::getName));
        orderedStudents = newSorter.getOrderedList();

        WriteCsv solution1 = new WriteCsv("src/main/resources/solution.csv", orderedStudents, "Student_Name,Course_Count");

        Sorter<Evaluation> sorter2 = new Sorter<>(evaluations, Comparator.comparing(Evaluation::getCourse)
                .thenComparing(Evaluation::getEvaluationName)
                .thenComparing(Evaluation::getStudent));

        WriteCsv expected2 = new WriteCsv("src/main/resources/solution_2.csv", evaluations, "Subject_Name,Evaluation_Name,Student_Name,Grade");


    }
}