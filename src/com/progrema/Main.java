package com.progrema;

import com.progrema.graph.BFS;
import com.progrema.queue.CircularArrayQueue;
import com.progrema.queue.Queue;
import com.progrema.stack.LinkedListStack;
import com.progrema.stack.Stack;
import com.progrema.tree.BST;

public class Main {

    public static void main(String[] args) {

        // Sort.test();

        // DoublyLinkedList.test();
        // SortedLinkedList.test();

        // ArrayStack.test();
        // LinkedListStack.test();
        // LinkedListStack.testPalindrome();

        // ArrayQueue.test();
        // LinkedListQueue.test();
        // CircularArrayQueue.test();
        // testPalindrome();

        // LinearProbing.test();
        // SeparateChaining.test();

        // LinearSearch.test();
        // BinarySearch.test();

        // BST.test();

        BFS.test();

    }

    public static void testPalindrome() {
        {
            char[] word = "racecar".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }

        {
            char[] word = "hello".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }

        {
            char[] word = "ididdidi".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }
    }

    private static boolean isPalindrome(char[] word) {

        Queue<Character> queue = new CircularArrayQueue<>();
        Stack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < word.length; i++) {
            queue.enqueue(word[i]);
            stack.push(word[i]);
        }

        for (int i = 0; i < word.length; i++) {
            if (queue.dequeue() != stack.pop()) {
                return false;
            }
        }

        return true;
    }

}
