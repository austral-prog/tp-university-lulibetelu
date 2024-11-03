package com.university;

import java.util.List;

public interface Formattable<T> extends Comparable<T>  {
    public String[] toStringForSolution();
}
