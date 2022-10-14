package dev.ahmed.java;

import static java.util.Arrays.binarySearch;

/**
 * @author Ahmed Bughra
 * @create 2022-09-24  1:33 AM
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 82, 33, 5, 65, 6, 66, 8, 9, 75, 13, 12, 63, 24, 15};
        int target = 15;
        int idx = binarySearch(array, target);
        System.out.println(idx);
    }

    // binarySearch, if could find a int in the array return index, else return -1
    public static int binarySearch(int[] array, int target) {
        int l = 0, r = array.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (array[m] == target) {
                return m;
            } else if (array[m] > target) {
                return m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}