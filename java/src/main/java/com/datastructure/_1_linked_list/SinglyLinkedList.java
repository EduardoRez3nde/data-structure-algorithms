package com.datastructure._1_linked_list;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private static class Node<T> {

        private T element;
        private Node<T> next;

        public Node() {}

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
    private Node<T> head = null;
    private Node<T> tail = null;
    private Long size = 0L;

    public SinglyLinkedList() {}

    @Override
    public Long size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return this.head.element;
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return this.tail.element;
    }

    @Override
    public void addFirst(T element) {
        this.head = new Node<>(element, head);
        if (isEmpty()) tail = head;
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newest = new Node<>(element, null);
        if (isEmpty()) head = newest;
        else tail.next = newest;
        tail = newest;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T element = head.element;
        head = head.next;
        size--;
        if (size == 0) tail = null;
        return element;
    }
}
