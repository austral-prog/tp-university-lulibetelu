package com.university.passingCriteria.criteria;

import java.util.List;

public class MaxAboveValue implements Checkable {
    public boolean approved(List<Float> grades, float criteria){
        boolean approved = false;
        for (Float grade: grades) {
            if (grade <= criteria) {
                approved = true;
            }
        }
        return approved;

    }
}
