package com.progrema;

public class LinkedList {

    public static void test() {

        EmployeeList list = new EmployeeList();

        System.out.println("size: " + list.getSize());

        list.add(new Employee("Iqbal", "Pakeh", 123));
        list.add(new Employee("John", "Doe", 456));
        list.add(new Employee("Hanifah", "Widiastuti", 456));
        list.print();

        System.out.print("size: " + list.getSize());
    }

    static class EmployeeList {

        private EmployeeNode head;
        private int size;


        public void add(Employee employee) {

            EmployeeNode oldHead = head;

            head = new EmployeeNode(employee);
            head.setNext(oldHead);

            size++;
        }

        public void print() {
            EmployeeNode current = head;
            while (current != null) {
                System.out.print(current.employee + " --> ");
                current = current.next;
            }
            System.out.println("NULL");
        }

        public int getSize() {
            return size;
        }

    }

    static class EmployeeNode {

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

    static class Employee {

        private String firstName;
        private String lastName;
        private int id;

        public Employee(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
