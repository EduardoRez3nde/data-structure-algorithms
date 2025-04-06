package com.datastructure._2_tree;

import java.util.Objects;

public abstract class TreeAbstract<T extends Comparable<T>> implements Tree<T> {

    protected class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        private T element;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node() {
            element = null;
            leftChild = null;
            rightChild = null;
        }

        public Node(T element, Node<T> leftChild, Node<T> rightChild) {
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(element, node.element);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(element);
        }


        @Override
        public int compareTo(Node<T> node) {
            return this.element.compareTo(node.element);
        }
    }

    public boolean isEmpty() { return size() == 0; }

    public Node<T> insert(Node<T> node, T value) {

        if (isEmpty())
            return new Node<>(value, null, null);

        if (node.element.compareTo(value) < 0)
            node.leftChild = insert(node.leftChild, value);
        else
            node.rightChild = insert(node.rightChild, value);

        return node;
    }

    public Integer height(Node<T> root) {
        if (isEmpty())
            return null;
        int left = height(root.leftChild);
        int right = height(root.rightChild);
        return Math.max(left, right) + 1;
    }

    public Node<T> search(Node<T> root, T value) {
        if (isEmpty() || root.element == value)
            return root;
        if (value.compareTo(root.element) < 0)
            return search(root.leftChild, value);
        return search(root.rightChild, value);
    }

    public void preOrder(Node<T> node) {
        if (node != null) {
            System.out.printf("%s ", node.element);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.printf("%s ", node.element);
            inOrder(node.rightChild);
        }
    }

    public void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.printf("%s ", node.element);
        }
    }
}
