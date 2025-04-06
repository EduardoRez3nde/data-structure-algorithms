package com.datastructure._1_linked_list;

public interface LinkedList<T> {

    Long size();
    boolean isEmpty();
    T first();
    T last();
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
}
