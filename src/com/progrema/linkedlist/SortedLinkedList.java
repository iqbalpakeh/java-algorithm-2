package com.progrema.linkedlist;

public class SortedLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        {
            // List list = new List();
            // list.addToHead(10);
            // list.addToHead(9);
            // list.addToHead(8);
            // list.addToHead(7);
            // list.addToHead(6);
            // list.addToHead(5);
            // list.addToHead(4);
            // list.addToHead(3);
            // list.addToHead(2);
            // list.addToHead(1);
            // list.printFromHead();

            List list = new List();
            list.addToHead(3);
            list.addToHead(5);
            list.addToHead(2);
            list.addToHead(8);
            list.addToHead(4);
            list.addToHead(1);
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
            } else {
                while (head != null && head.val < object) {
                    head = head.next;
                }
                Node newNode = new Node(object);
                newNode.next = head;
                head = newNode;
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
            while (current != null) {
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
