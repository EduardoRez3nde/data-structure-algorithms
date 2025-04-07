package com.datastructure._1_linked_list;

public class CircularlyLinkedList<T> implements LinkedList<T> {

    private static class Node<T> {

        private T element;
        private Node<T> next;

        public Node() {}

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
    private Long size = 0L;
    private Node<T> tail = null;

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
        return tail.next.element;
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return tail.element;
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            tail = new Node<>(element, null);
            tail.next = tail;
        }
        else {
            tail.next = new Node<>(element, tail.next);
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        addFirst(element);
        tail = tail.next;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node<T> head = tail.next;
        if (head == tail) tail = null;
        else tail.next = head.next;
        size--;
        return head.element;
    }
}
