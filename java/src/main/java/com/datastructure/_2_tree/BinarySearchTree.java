package com.datastructure._2_tree;

public class BinarySearchTree<T extends Comparable<T>> extends TreeAbstract<T> implements Tree<T>{

    private Node<T> root = null;
    private int size = 0;



    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T value) {

    }


}
