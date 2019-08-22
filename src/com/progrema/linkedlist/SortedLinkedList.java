package com.progrema.linkedlist;

public class SortedLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        {
            List list = new List();
            list.addToHead(1);
            list.addToHead(2);
            list.addToHead(3);
            list.addToHead(4);
            list.printFromHead();
        }
    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class List implements LinkedList<Integer> {

        private Node head;
        private int size;

        @Override
        public void addToHead(Integer object) {
            if (size == 0) {
                head = new Node(object);
                size++;
                return;
            }
            Node current = head;
            while (current.val < object) {
                current = current.next;
            }
            if (current.next == null) {
                current.next = new Node(object);
            } else {
                Node oldCurrent = current;
                current = new Node(object);
                current.next = oldCurrent.next;
                oldCurrent.next = current;
            }
            size++;
        }

        @Override
        public void addToTail(Integer object) {

        }

        @Override
        public void removeHead() {

        }

        @Override
        public void removeTail() {

        }

        @Override
        public void addBefore(Integer newObject, Integer targetObject) {

        }

        @Override
        public void printFromHead() {
            Node current = head;
            System.out.print("HEAD -> ");
            while (current.next != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.print("NULL");
            System.out.println(", SIZE = " + getSize());
        }

        @Override
        public void printFromTail() {

        }

        @Override
        public void printHead() {

        }

        @Override
        public void printTail() {

        }

        @Override
        public int getSize() {
            return size;
        }

    }

    // --------------------------------------------------------------------
    // NODE
    // --------------------------------------------------------------------

    private static class Node {

        public int val;
        public Node next;

        public Node(int data) {
            this.val = data;
        }
    }

}
