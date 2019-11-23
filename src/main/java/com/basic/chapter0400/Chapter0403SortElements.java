package com.basic.chapter0400;

/**
 * 排序数组: 选择排序(Selection Sort)
 *
 * @author MarkShen
 * @since 20191123
 */
public class Chapter0403SortElements {

    private static int[] arr = {6, 9, 5, 4, 9, 12};

    public static void main(String[] args) {
        int[] array = selectionSort(arr);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * algorithm implementation method
     * algorithm thinking:
     *
     * @param arr
     * @return
     */
    private static int[] selectionSort(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = 0;
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
