package com.progrema;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {20, 35, -15, 7, 55, 1, -22};
        show("unsorted", arr);
        selectionSort(arr);
        show("sorted  ", arr);
    }

    private static void selectionSort(int[] arr) {
        int largestIndex;
        for (int stopIndex = arr.length - 1; stopIndex >= 0; stopIndex--) {
            largestIndex = 0;
            for (int i = 1; i <= stopIndex; i++ ) {
                if(arr[largestIndex] < arr[i]) {
                    largestIndex = i;
                }
            }
            swap(arr, largestIndex, stopIndex);
            // show("stopIndex " + stopIndex, arr); // debugging code!
        }
    }

    private static void show(String name, int[] arr) {
        System.out.print(name + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
