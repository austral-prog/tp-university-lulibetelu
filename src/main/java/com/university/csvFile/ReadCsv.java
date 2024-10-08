package com.university.csvFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    public ReadCsv(String filePath){
        readCsv(filePath);
    }

    public void readCsv(String filePath){
        String line = "";
        String splitBy = ",";
        BufferedReader br = null;
        List<String[]> data = new ArrayList<>();

        try {
            // Ruta del archivo 'expected.csv' en la carpeta 'resources'
            br = new BufferedReader(new FileReader(filePath));

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

}
