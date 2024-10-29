package com.university.passingCriteria;

public class MinAboveValue implements Approvable{
    private float grade;
    private float criteria;
    public MinAboveValue(float grade, float criteria){
        this.grade = grade;
        this.criteria = criteria;
    }

    @Override
    public boolean approved() {
        boolean approved = false;
        if (grade >= criteria){
            approved = true;
        }
        return approved;

    }
}
