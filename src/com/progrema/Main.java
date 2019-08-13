package com.progrema;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {20, 35, -15, 7, 55, 1, -22};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
