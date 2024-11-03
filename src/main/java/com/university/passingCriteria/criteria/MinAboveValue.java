package com.university.passingCriteria.criteria;

import java.util.List;

public class MinAboveValue implements Checkable {
    private List<Float> grades;
    private float criteria;
    public MinAboveValue(List<Float> grades, float criteria){
        this.grades = grades;
        this.criteria = criteria;
    }

    @Override
    public boolean approved() {
        boolean approved = true;
        for (Float grade: grades) {
            if (grade < criteria) {
                approved = false;
            }
        }
        return approved;

    }

}
