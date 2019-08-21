package com.progrema.linkedlist;

public interface LinkedList {

    void addToHead(Employee employee);

    void addToTail(Employee employee);

    void removeHead();

    void removeTail();

    void addBefore(Employee newEmployee, Employee target);

    void printFromHead();

    void printFromTail();

    void printHead();

    void printTail();

    int getSize();

}
