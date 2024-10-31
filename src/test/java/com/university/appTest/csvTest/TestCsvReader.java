package com.university.appTest.csvTest;

import com.university.csvFile.ReadCsv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCsvReader {
    @Test
    public void readCsv(){
        ReadCsv reader = new ReadCsv("src/main/resources/input.csv");
        assertEquals(reader.getData().get(0)[0], "578");
        assertEquals(reader.getData().get(0)[1], "Political Science");
        assertEquals(reader.getData().get(0)[2], "Olivia Red");
        assertEquals(reader.getData().get(0)[3], "olivia.red@student.org");
        assertEquals(reader.getData().get(0)[4], "Prof. Sam");

    }
}
