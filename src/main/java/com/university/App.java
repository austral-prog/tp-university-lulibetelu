package com.university;
import com.university.course.Course;
import com.university.student.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

public class App {
    static List<String[]> data = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();


    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        BufferedReader br = null;

        try {
            // Ruta del archivo 'expected.csv' en la carpeta 'resources'
            br = new BufferedReader(new FileReader("src/main/resources/input.csv"));

            while (true) {
                try {
                    if ((line = br.readLine()) == null) break; // si la linea esta vacia saltea
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (!line.equals("Classroom,Subject,Student_Name,Student_Email,Subject_Teacher")) {
                    String[] values = line.split(splitBy);  // Usa coma como separador
                    data.add(values); // guarda los valores por fila
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void createStudent() {
        for (int i = 0; i < data.size(); i++){  // recorro las listas
            int count = 0;
            boolean found = false;
            while (count < students.size()){
                if (students.get(count).getName().equals(data.get(i)[2]) && students.get(count).getEmail().equals(data.get(i)[3])) {
                    found = true;  // checkeo si el estudiante ya fue creado y si esta en la lista de students
                    break;
                }
                count ++;
            }
            if (!found) {
                Student student = new Student(data.get(i)[2], data.get(i)[3]);
                students.add(student);
            }
        }

    }

    public void createCourse() {
        for (String[] datum : data) {  // recorro las listas
            int count = 0;
            boolean found = false;
            while (count < courses.size()) {
                if (courses.get(count).getSubject().equals(datum[0])
                        && courses.get(count).getSubject().equals(datum[1])
                        && courses.get(count).getSubject().equals(datum[4])) {

                    found = true;
                    break;
                }
                count++;
            }
            if (!found) {
                Course course = new Course(datum[0], datum[1], datum[4]);
                courses.add(course);
            }
        }

    }

    public void coursesPerStudent(){
        for (Student student : students) {
            for (String[] datum : data) {
                if (datum[2].equals(student.getName()) && datum[3].equals(student.getEmail())) { // me fijo si el estudiante que tengo es el mismo de esa linea
                    for (Course course: courses){
                        if (course.getSubject().equals(datum[1])){ // me fijo la materia que cursa
                            if (!student.getSubjects().contains(course)) {
                                student.addSubject(course); // lo agrega a la lista de materias que cursa el estudiante
                            }
                        }
                    }
                }
            }
        }
    }

    public void studentsPerCourse(){
        for (Course course: courses){
            for (String[] datum : data) {
                if (datum[1].equals(course.getSubject()) && datum[0].equals(course.getClassroom()) && datum[4].equals(course.getTeacher())) { // me fijo si es el mismo curso
                     for (Student student : students) {
                        if (student.getName().equals(datum[2])){ // me fijo que estudiante cursa esa materia
                            if (!course.getStudents().contains(student)) {
                                course.addStudents(student); // lo agrego a la lista de estudiantes que la cursan
                            }
                        }
                    }
                }
            }
        }
    }

    // Función para escribir el archivo CSV con la cantidad de materias por estudiante
    public void writeSolutionCSV() {
        try (FileWriter writer = new FileWriter("src/main/resources/solution.csv")) {
            writer.append("Student_Name,Number_of_Courses\n"); // Encabezado

            for (Student student : students) {
                writer.append(student.getName()) // Nombre del estudiante
                        .append(",")
                        .append(String.valueOf(student.courseCount())) // Número de materias que cursa
                        .append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents(){
        return students;
    }

    public List<Course> getCourses(){
        return courses;
    }





}


