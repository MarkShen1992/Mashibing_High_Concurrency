package com.java8;

/**
 * @author MarkShen
 */
public class Demo0100_LambdaRunnable {
    public static void main(String[] args) {
        // 用lambda表达式实现Runnable
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8方式：
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();

        // 这个例子向我们展示了Java 8 lambda表达式的语法。你可以使用lambda写出如下代码
        // (params) -> expression
        // (params) -> statement
        // (params) -> { statements }

        // 如果你的方法不对参数进行修改、重写，只是在控制台打印点东西的话
        // () -> System.out.println("Hello Lambda Expressions");

        // 如果你的方法接收两个参数
        // (int even, int odd) -> even + odd
    }
}
