package com.university.sortable;

import com.university.Printable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter <T>{
    private List<T> list;
    private Comparator<T> comparator;
    public Sorter (List<T> list, Comparator<T> comparator){
        this.comparator = comparator;
        this.list = list;
        sort();
    }

    public List<T> sort() {
        list.sort(comparator);
        return list;
    }
    public List<T> getOrderedList(){
        return list;
    }
}
