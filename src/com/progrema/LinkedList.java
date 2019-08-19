package com.progrema;

public class LinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        EmployeeList list = new EmployeeList();

        System.out.println("size: " + list.getSize());

        list.add(new Employee("Iqbal", "Pakeh", 123));
        list.add(new Employee("John", "Doe", 456));
        list.add(new Employee("Hanifah", "Widiastuti", 456));
        list.print();

        System.out.println("size: " + list.getSize());

        list.remove();
        list.print();

        System.out.println("size: " + list.getSize());
    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class EmployeeList {

        private EmployeeNode head;
        private int size;

        public void add(Employee employee) {
            EmployeeNode oldHead = head;
            head = new EmployeeNode(employee);
            head.setNext(oldHead);
            size++;
        }

        public void remove() {
            EmployeeNode oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
            size--;
        }

        public void print() {
            EmployeeNode current = head;
            while (current != null) {
                System.out.print(current.employee + " --> ");
                current = current.getNext();
            }
            System.out.println("NULL");
        }

        public int getSize() {
            return size;
        }

    }

    // --------------------------------------------------------------------
    // NODE
    // --------------------------------------------------------------------

    private static class EmployeeNode {

        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }
    }

    // --------------------------------------------------------------------
    // OBJECT
    // --------------------------------------------------------------------

    private static class Employee {

        private String firstName;
        private String lastName;
        private int id;

        public Employee(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}
