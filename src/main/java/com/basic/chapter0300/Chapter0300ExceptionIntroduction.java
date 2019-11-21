package com.basic.chapter0300;

/**
 * Exception
 *      异常的概念
 *      Java异常的分类
 *      异常的捕获和处理
 *      运行期出现的问题
 *
 *      观察错误的名字和行号特别重要
 *      程序是调出来的
 *
 * @author MarkShen1992
 * @since 20191121
 */
public class Chapter0300ExceptionIntroduction {
    public static void main(String[] args) {
        /**
         * 对于数组越界问题，C, C++ 语言中会有问题，缓冲区溢出漏洞。
         * 所以写C, C++ 程序的时候，一定要安全内容
         *
         * Java异常是Java提供的处理程序错误的一种机制
         * 所谓错误是指在程序运行的时候发生的一些异常事件
         * 设计好的程序应该在发生异常时提供异常处理的方法，使得程序不会因为异常的发生而阻断
         * 或产生不可预期的后果。
         * Java程序的执行过程中如果出现异常事件，可以生成一个异常对象，该异常对象封装了异常
         * 事件的信息，并被提交给Java运行时系统，这个过程称为抛出异常。
         * 当Java运行时系统接收到异常对象时，会寻找可以处理异常的方法，并把当前异常对象交给
         * 其处理，这个过程称为捕获异常。
         *
         * try() {
         *     ...代码
         * } catch (XXXException e) {
         *     捕获异常后处理
         * } catch (YYYException e2) {
         *     ...
         * } finally {
         *      产不产生异常，finally中的语句一定会执行
         *     关闭资源
         * }
         *
         * catch 异常的时候，要先 catch 具体的（小的）异常，然后再 catch 抽象的（大的）异常
         */
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("系统正在维护中，请稍后，请与管理员联系，谢谢");
            e.printStackTrace();
        }
    }
}
