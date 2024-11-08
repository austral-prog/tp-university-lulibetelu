package com.university.passingCriteria.criteria;

import java.util.List;

public class MinAboveValue implements Checkable {
    @Override
    public boolean approved(List<Float> grades, float criteria) {
        boolean approved = true;
        for (Float grade: grades) {
            if (grade < criteria) {
                approved = false;
            }
        }
        return approved;

    }

}
