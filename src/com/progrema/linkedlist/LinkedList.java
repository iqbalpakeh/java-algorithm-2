package com.progrema.linkedlist;

public interface LinkedList<T> {

    void addToHead(T object);

    void addToTail(T object);

    void removeHead();

    void removeTail();

    void addBefore(T newObject, T targetObject);

    void printFromHead();

    void printFromTail();

    void printHead();

    void printTail();

    int getSize();

}
