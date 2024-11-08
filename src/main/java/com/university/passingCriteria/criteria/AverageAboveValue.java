package com.university.passingCriteria.criteria;

import java.util.List;

public class AverageAboveValue implements Checkable {
    @Override
    public boolean approved(List<Float> grades, float criteria) {
        boolean approved = false;
        float sum = 0;
        for (Float grade: grades){
            sum += grade;
        }
        if ((sum / grades.size()) >= criteria){
             approved = true;
        }
        return approved;
    }
}
