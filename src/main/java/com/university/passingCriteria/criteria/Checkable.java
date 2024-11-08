package com.university.passingCriteria.criteria;

import java.util.List;

public interface Checkable {
    public boolean approved(List<Float> grades, float criteria);
}
