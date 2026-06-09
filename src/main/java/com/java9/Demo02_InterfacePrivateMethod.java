package com.java9;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 9 新特性：接口私有方法
 * 在接口中定义 private / private static 方法，复用 default 方法中的逻辑。
 */
public class Demo02_InterfacePrivateMethod {

    interface Logger {
        void log(String message);

        default void info(String msg) { logWithLevel("INFO", msg); }
        default void warn(String msg) { logWithLevel("WARN", msg); }
        default void error(String msg) { logWithLevel("ERROR", msg); }

        // Java 9: 私有方法
        private void logWithLevel(String level, String msg) {
            log("[" + level + "] " + msg);
        }

        // Java 9: 私有静态方法
        static void printLine() { System.out.println(repeat("-", 40)); }
        private static String repeat(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append(s);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Logger logger = msg -> System.out.println(msg);

        logger.info("应用启动");
        logger.warn("内存使用率较高");
        logger.error("数据库连接失败");
        Logger.printLine();
    }
}
