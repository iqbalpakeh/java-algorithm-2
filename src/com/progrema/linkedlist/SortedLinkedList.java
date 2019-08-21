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

        private int[] arr;
        private int size;

        public List() {

        }

        @Override
        public void addToHead(Integer object) {

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
            System.out.print("HEAD --> ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " <--> ");
            }
            System.out.println("NULL");
            System.out.println("SIZE: " + getSize());
            System.out.println();
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

        private void resize() {
            // todo
        }
    }

    // --------------------------------------------------------------------
    // NODE
    // --------------------------------------------------------------------

    private static class Node {
        public int val;
        public Node next;
        public Node prev;
    }

}
