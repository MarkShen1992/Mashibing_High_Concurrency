package com.basic.chapter0300;

/**
 * Method Exception handle
 * 能处理的一定要处理，处理不了的往外抛
 * 多读设计精巧的源码，体会设计思想尤为重要
 *
 * 异常和继承之间的关系
 * 重写方法需要抛出与原方法所抛出异常类型一致异常或不抛出异常。
 *
 * @author MarkShen
 * @since 20191121
 */
public class Chapter0303Junk {
    public static void main(String args[]) {
        try {
            a();
        } catch (HighLevelException e) {
            e.printStackTrace();
        }
    }

    static void a() throws HighLevelException {
        try {
            b();
        } catch (MidLevelException e) {
            throw new HighLevelException(e);
        }
    }

    static void b() throws MidLevelException {
        c();
    }

    static void c() throws MidLevelException {
        try {
            d();
        } catch (LowLevelException e) {
            throw new MidLevelException(e);
        }
    }

    static void d() throws LowLevelException {
        e();
    }

    static void e() throws LowLevelException {
        throw new LowLevelException();
    }
}

/**
 * 使用自定义异常一般有如下步骤：
 * 1. 通过继承 java.lang.Exception类声明自己的异常类
 * 2. 在方法适当的位置生成自定义异常的实例，并用throw抛出
 * 3. 方法级使用 throws 语句声明该方法可能抛出的异常
 */
class HighLevelException extends Exception {
    HighLevelException(Throwable cause) {
        super(cause);
    }
}

class MidLevelException extends Exception {
    MidLevelException(Throwable cause) {
        super(cause);
    }
}

class LowLevelException extends Exception {
}
