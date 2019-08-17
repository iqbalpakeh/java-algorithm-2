package com.progrema;

import com.sun.istack.internal.NotNull;

import static com.progrema.Sort.*;

public class Main {

    public static void main(String[] args) {

        // int[] arrInit = {20, 35, -15, 7, 55, 1, -22};
        int[] arrInit = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = new int[arrInit.length];

        System.out.println("\nBubble Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        bubbleSort(arr);
        show("sorted  ", arr);

        System.out.println("\nSelection Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        selectionSort(arr);
        show("sorted  ", arr);

        System.out.println("\nInsertion Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        insertionSort(arr);
        show("sorted  ", arr);

        System.out.println("\nShell Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        shellSort(arr);
        show("sorted  ", arr);

        System.out.println("\nMerge Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        mergeSort(arr);
        show("sorted  ", arr);

        System.out.println("\nQuick Sort");
        copyArr(arrInit, arr);
        show("unsorted", arr);
        quickSort(arr);
        show("sorted  ", arr);

    }

    private static void show(String name, @NotNull int[] arr) {
        System.out.print(name + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
