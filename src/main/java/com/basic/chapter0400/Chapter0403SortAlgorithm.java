package com.basic.chapter0400;

/**
 * 排序数组: 选择排序(Selection Sort)
 * 写程序先跑主流程，主流程跑通后再考虑程序的细节
 *
 * 如何分析一个你不熟悉的算法呢？
 * 在纸上 画图分析，分析i等于0, 1, 2, ...的情况, 找规律
 *
 * 十大经典排序算法（动图演示）
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 *
 * @author MarkShen
 * @since 20191123
 */
public class Chapter0403SortAlgorithm {

    // selection algorithm
    private static int[] arr = {6, 9, 5, 4, 9, 12};
    private static double[] arr2 = {0.1, 0.2, 0.3, 0.1};

    // bubble sort algorithm
    private static int[] arr3 = {1, 2, 4, 3, 9, 2};

    public static void main(String[] args) {
        int[] array = selectionSort(arr);
        for (int i : array) {
            System.out.println(i);
        }

        double[] arr = selectionSort(arr2);
        for (double d : arr) {
            System.out.println(d);
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

    /**
     * 选择排序算法
     *
     * @param arr
     * @return
     */
    private static double[] selectionSort(double[] arr) {
        if (arr == null) {
            return new double[0];
        }
        double len = arr.length;
        int minIndex;
        double temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
