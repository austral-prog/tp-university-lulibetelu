package com.university;

import com.university.course.Course;
import com.university.course.CreateCourses;
import com.university.course.StudentsPerCourse;
import com.university.csvFile.WriteCsv;
import com.university.evaluation.CreateEvaluation;
import com.university.evaluation.Evaluationold;
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
    static List<Evaluationold> evaluations = new ArrayList<>();
    static List<Student> orderedStudents = new ArrayList<>();

    public Factory(List<String[]> data, List<String[]> data2){

        CreateStudent createStudent = new CreateStudent(data);
        students = createStudent.getStudents();

        CreateCourses createCourses = new CreateCourses(data);
        courses = createCourses.getCourses();

        CoursesPerStudent coursesPerStudent = new CoursesPerStudent(data, students, courses);

        StudentsPerCourse studentsPerCourse = new StudentsPerCourse(data, students, courses);

        Sorter<Student> newSorter = new Sorter<>(students, Comparator.comparing(Student::getName));
        orderedStudents = newSorter.getOrderedList();

        WriteCsv writeCsv = new WriteCsv("src/main/resources/solution.csv", orderedStudents, "Student_Name,Course_Count");


        CreateEvaluation evaluation = new CreateEvaluation(data2, courses, orderedStudents);
        evaluations = evaluation.getEvaluations();
    }
}
