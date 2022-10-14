package dev.ahmed.java;


import java.util.Arrays;

/**
 * @author Ahmed Bughra
 * @create 2022-09-24  2:12 AM
 */
public class BubbelSort {
    public static void main(String[] args) {
        int[] a = {95, 68, 18, 94, 4, 83, 47, 8,44};
        bubble(a);
    }

    private static void bubble(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {

            // firt loop of bubble sort
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                }
            }
            System.out.println("No. " + j + " loop for bubbleSort " + Arrays.toString(a));
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
