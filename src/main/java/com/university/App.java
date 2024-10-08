package com.university;
import com.university.course.Course;
import com.university.course.CreateCourses;
import com.university.course.StudentsPerCourse;
import com.university.csvFile.ReadCsv;
import com.university.csvFile.WriteCsv;
import com.university.student.CoursesPerStudent;
import com.university.student.CreateStudent;
import com.university.student.SortStudents;
import com.university.student.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


import java.util.ArrayList;
import java.util.List;

public class App {
    static List<String[]> data = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static List<Student> orderedStudents = new ArrayList<>();


    public static void main(String[] args) {

        ReadCsv readCsv = new ReadCsv(args);
        data = readCsv.getData();

        CreateStudent createStudent = new CreateStudent(data);
        students = createStudent.getStudents();

        CreateCourses createCourses = new CreateCourses(data);
        courses = createCourses.getCourses();

        CoursesPerStudent coursesPerStudent = new CoursesPerStudent(data, students, courses);

        StudentsPerCourse studentsPerCourse = new StudentsPerCourse(data, students, courses);

        SortStudents orderedList = new SortStudents(students);
        orderedStudents = orderedList.getSortedStudents();

        WriteCsv writeCsv = new WriteCsv(orderedStudents);

    }


    public List<Student> getStudents(){
        return students;
    }

    public List<Course> getCourses(){
        return courses;
    }






}


