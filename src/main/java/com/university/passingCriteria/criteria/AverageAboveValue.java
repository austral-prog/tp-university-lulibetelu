package com.university.passingCriteria.criteria;

import java.util.List;

public class AverageAboveValue implements Checkers{
    private List<Float> grades;
    private float criteria;
    public AverageAboveValue(List<Float> grades, float criteria){
        this.grades = grades;
        this.criteria = criteria;
    }

    @Override
    public boolean approved() {
        boolean approved = false;
        float sum = 0;
        for (Float grade: grades){
            sum += grade;
        }
        if (sum / criteria > criteria){
             approved = true;
        }
        return approved;
    }
}
