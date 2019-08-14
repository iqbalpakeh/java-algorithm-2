package com.progrema;

import com.sun.istack.internal.NotNull;

public class Main {

    public static void main(String[] args) {

        // {
        //     System.out.println("\nBubble Sort");
        //     int[] arr = {20, 35, -15, 7, 55, 1, -22};
        //     show("unsorted", arr);
        //     bubbleSort(arr);
        //     show("sorted  ", arr);
        // }
        //
        // {
        //     System.out.println("\nSelection Sort");
        //     int[] arr = {20, 35, -15, 7, 55, 1, -22};
        //     show("unsorted", arr);
        //     selectionSort(arr);
        //     show("sorted  ", arr);
        // }
        //
        // {
        //     System.out.println("\nInsertion Sort");
        //     int[] arr = {20, 35, -15, 7, 55, 1, -22};
        //     show("unsorted", arr);
        //     insertionSort(arr);
        //     show("sorted  ", arr);
        // }

        {
            System.out.println("\nShell Sort");
            int[] arr = {20, 35, -15, 7, 55, 1, -22};
            show("unsorted", arr);
            shellSort(arr);
            show("sorted  ", arr);
        }

    }

    private static void shellSort(@NotNull int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            int ne, j;
            for (int i = gap; i < arr.length; i++) {
                ne = arr[i];
                for (j = i; (j > 0) && (ne < arr[j - gap]); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = ne;
            }
        }
    }

    private static void insertionSort(@NotNull int[] arr) {
        for (int fui = 1; fui < arr.length; fui++) {
            int i;
            int ne = arr[fui];
            for (i = fui; (i > 0) && (arr[i - 1] > ne); i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = ne;
        }
    }

    private static void bubbleSort(@NotNull int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void selectionSort(@NotNull int[] arr) {
        int largestIndex;
        for (int stopIndex = arr.length - 1; stopIndex >= 0; stopIndex--) {
            largestIndex = 0;
            for (int i = 1; i <= stopIndex; i++) {
                if (arr[largestIndex] < arr[i]) {
                    largestIndex = i;
                }
            }
            swap(arr, largestIndex, stopIndex);
        }
    }

    private static void show(String name, @NotNull int[] arr) {
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
