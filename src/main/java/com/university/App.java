package com.university;
import com.university.course.Course;
import com.university.csvFile.ReadCsv;
import com.university.student.Student;


import java.util.ArrayList;
import java.util.List;

public class App {
    static List<String[]> data = new ArrayList<>();
    static List<String[]> data2 = new ArrayList<>();
    static List<String[]> data3 = new ArrayList<>();

    public static void main(String[] args) {
        ReadCsv readInput = new ReadCsv("src/main/resources/input.csv");
        data = readInput.getData();

        ReadCsv readInput2 = new ReadCsv("src/main/resources/input_2.csv");
        data2 = readInput2.getData();

        ReadCsv readInput3 = new ReadCsv("src/main/resources/input_3.csv");
        data3 = readInput3.getData();

        Factory newClasses = new Factory(data, data2, data3);


    }





}


