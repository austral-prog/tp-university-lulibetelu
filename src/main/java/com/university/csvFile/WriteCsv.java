package com.university.csvFile;

import com.university.Formattable;
import com.university.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCsv {
    public WriteCsv(String path, List<? extends Formattable> solution, String categories) {
        writeCsv(path, solution, categories);

    }

    public void writeCsv(String path, List<? extends Formattable> solution, String categories) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.append(categories) // Encabezado
                    .append("\n");
            for (Formattable element : solution) {
                for (int i= 0; i<element.toStringForSolution().length;i++){
                    if (!element.toStringForSolution()[i].equals("")) {
                        writer.append(element.toStringForSolution()[i]);
                        writer.append("\n");
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


