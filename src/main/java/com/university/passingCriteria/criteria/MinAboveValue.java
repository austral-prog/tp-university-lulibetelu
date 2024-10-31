package com.university.passingCriteria.criteria;

public class MinAboveValue implements Checkers{
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
