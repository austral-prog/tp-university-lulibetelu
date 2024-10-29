package com.university.passingCriteria;

import java.util.List;

public class AverageAboveValue implements Approvable{
    public AverageAboveValue(List<String> grades, float criteria){

    }

    @Override
    public boolean approved() {
        return false;
    }
}
