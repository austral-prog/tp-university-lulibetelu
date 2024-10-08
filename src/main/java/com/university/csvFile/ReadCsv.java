package com.university.csvFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    List<String[]> data = new ArrayList<>();
    public ReadCsv(){
        readCsv();
    }

    public void readCsv(){
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
    public List<String[]> getData(){
        return data;
    }

}
