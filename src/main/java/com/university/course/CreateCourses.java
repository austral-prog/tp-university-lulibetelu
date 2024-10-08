package com.university.course;

import java.util.ArrayList;
import java.util.List;

public class CreateCourses {
    private List<Course> courses;
    public CreateCourses(List<String[]> data){
        this.courses = new ArrayList<>();
        createCourses(data);
    }
    public List<Course> createCourses(List<String[]> data){
        for (String[] datum : data) {  // recorro las listas
            int count = 0;
            boolean found = false;
            while (count < courses.size()) {
                if (courses.get(count).getSubject().equals(datum[1])) {
                    found = true;
                    break;
                }
                count++;
            }
            if (!found) {
                Course course = new Course(datum[0], datum[1], datum[4]);
                courses.add(course);
            }
        }
        return courses;
    }

    public List<Course> getCourses(){
        return courses;
    }

}
