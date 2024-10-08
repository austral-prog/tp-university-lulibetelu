package com.university.student;

import java.util.ArrayList;
import java.util.List;

public class SortStudents {
    private List<Student> sortedStudents;

    public SortStudents(List<Student> unsortedStudentList) {

        this.sortedStudents = new ArrayList<>();
        sortStudents(unsortedStudentList);
    }

    public void sortStudents(List<Student> unsortedStudentList) {
        while (!unsortedStudentList.isEmpty()) {
            Student first = unsortedStudentList.getFirst();
            for (int i = 0; i < unsortedStudentList.size(); i++) {
                if (first.getName().compareTo(unsortedStudentList.get(i).getName()) > 0) {
                    first = unsortedStudentList.get(i);
                }
            }
            sortedStudents.add(first);
            unsortedStudentList.remove(first);
        }

    }

    public List<Student> getSortedStudents(){
        return sortedStudents;
    }
}

