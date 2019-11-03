package com.progrema.linkedlist;

public class GeneralLinkedList<T> {

    private Node<T> head;

    public static void test() {
        GeneralLinkedList<Integer> list = new GeneralLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
    }

    public void add(T data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    public void remove(T data) {
        Node current = head;
        while (!current.equals(data)) {
            current = current.next;
        }
        // Case head

        // Case middle

        // Case last
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
