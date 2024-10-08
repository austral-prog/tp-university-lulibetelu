package com.university.csvFile;

import com.university.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCsv {
    public WriteCsv(List<Student> orderedStudents){
        writeCsv(orderedStudents);
    }
    public void writeCsv(List<Student> orderedStudents){
        try (FileWriter writer = new FileWriter("src/main/resources/solution.csv")) {
            writer.append("Student_Name,Course_Count\n"); // Encabezado

            for (Student student : orderedStudents) {
                writer.append(student.getName()) // Nombre del estudiante
                        .append(",")
                        .append(String.valueOf(student.courseCount())) // Número de materias que cursa
                        .append("\n");
            }
            writer.append("\n");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
