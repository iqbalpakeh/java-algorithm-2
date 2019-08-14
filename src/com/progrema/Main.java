package com.progrema;

import com.sun.istack.internal.NotNull;

import static com.progrema.Sort.*;

public class Main {

    public static void main(String[] args) {

        int[] arrInit = {20, 35, -15, 7, 55, 1, -22};
        int[] arr;

        System.out.println("\nBubble Sort");
        arr = arrInit;
        show("unsorted", arr);
        bubbleSort(arr);
        show("sorted  ", arr);

        System.out.println("\nSelection Sort");
        arr = arrInit;
        show("unsorted", arr);
        selectionSort(arr);
        show("sorted  ", arr);

        System.out.println("\nInsertion Sort");
        arr = arrInit;
        show("unsorted", arr);
        insertionSort(arr);
        show("sorted  ", arr);

        System.out.println("\nShell Sort");
        arr = arrInit;
        show("unsorted", arr);
        shellSort(arr);
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
