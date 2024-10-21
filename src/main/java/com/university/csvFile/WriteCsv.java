package com.university.csvFile;

import com.university.Printable;
import com.university.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCsv {
    public WriteCsv(String path, List<? extends Printable> solution, String categories) {
        writeCsv(path, solution, categories);

    }

    public void writeCsv(String path, List<? extends Printable> solution, String categories) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.append(categories) // Encabezado
                    .append("\n");
            for (Printable element : solution) {
                writer.append(element.toStringForSolution());
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


