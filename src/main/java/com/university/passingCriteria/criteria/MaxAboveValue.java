package com.university.passingCriteria.criteria;

public class MaxAboveValue implements Checkable {
    private float grade;
    private float criteria;
    public MaxAboveValue(float grade, float criteria){
        this.grade = grade;
        this.criteria = criteria;
    }
    public boolean approved(){
        boolean approved = false;
        if (grade <= criteria){
            approved = true;
        }
        return approved;
    }
}
