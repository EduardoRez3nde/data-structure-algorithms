package com.datastructure.sorting.util;

public class SortUtil {

    public static <T extends Comparable<T>> boolean less(T first, T second) {
        return first.compareTo(second) < 0;
    }
}
