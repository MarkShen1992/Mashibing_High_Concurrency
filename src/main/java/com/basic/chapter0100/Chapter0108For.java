package com.basic.chapter0100;

/**
 * for语句, 计算1到 100这100个数之和
 * foreach语句打印
 * 分析算法时候，分析内存，找到规律。分析别人的算法，多分析别人的程序
 * 多读别人的程序，提炼一些好的算法，算法慢慢积累，多看看数学
 *
 * @author MarkShen1992
 * @since 20191103
 */
public class Chapter0108For {
    public static void main(String[] args) {
        long result = 0;
        for (int i = 1; i <= 100; i ++) {
            result += i;
        }
        System.out.println("result=" + result);
        foreachTest();
        System.out.println("factorial = " + factorialCompute(3));
        System.out.println(factorialRecursion(3));
    }

    /**
     * print the array elements
     */
    public static void foreachTest() {
        int[] arr = {1, 2, 3, 4};
        for (int number : arr) {
            System.out.println(number);
        }
    }

    /**
     * 计算 factorial 的阶乘, 1! + 2! + 3! + ... + factorial!
     *
     * @param factorial
     * @return
     */
    public static int factorialCompute(int factorial) {
        // 好的编程习惯，要对传进来的参数进行判断
        if (factorial <= 0) {
            return 0;
        }

        // 最终的一结果
        int result = 0;
        // 临时变量存数
        int tmpNum = 1;
        for (int i = 1; i <= factorial; i++) {
            tmpNum *= i;
            result += tmpNum;
        }
        return result;
    }

    /**
     * 递归实现阶乘
     *
     * @param factorial
     * @return
     */
    public static int factorialRecursion(int factorial) {
        if (factorial <= 0) {
            return 0;
        }

        if (factorial == 1) {
            return 1;
        }
        return factorial * factorialRecursion(-- factorial);
    }
}