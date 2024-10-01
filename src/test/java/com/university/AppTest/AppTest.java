package com.university.AppTest;

import com.university.App;
import com.university.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    private App app;

    @BeforeEach
    public void setup() {
        // Inicializa el objeto App
        app = new App();
        app.main(null);
    }

    @Test
    public void testCreateStudents(){
        List<Student> students = app.getStudents();
        assertNotNull(students);


    }

}
