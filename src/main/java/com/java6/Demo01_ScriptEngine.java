package com.java6;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.Invocable;

/**
 * Java 6 新特性：ScriptEngine API（脚本引擎）
 * 内置对 JavaScript 的支持，可在 Java 中执行动态脚本。
 * 注意：Java 15+ 已移除 Nashorn 引擎，高版本需额外引入 graalvm-js。
 */
public class Demo01_ScriptEngine {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        if (engine == null) {
            System.out.println("未找到 JavaScript 引擎（Java 15+ 已移除 Nashorn）");
            System.out.println("ScriptEngine API 用法:");
            System.out.println("  engine.eval(\"3 + 4 * 2\")        -> 11");
            System.out.println("  engine.put(\"x\", 10)             -> 设置变量");
            System.out.println("  engine.eval(\"x + 20\")           -> 30");
            System.out.println("  invocable.invokeFunction(\"fact\", 5) -> 120");
            return;
        }

        // 执行表达式
        System.out.println("3 + 4 * 2 = " + engine.eval("3 + 4 * 2"));

        // 传递变量
        engine.put("x", 10);
        engine.put("y", 20);
        System.out.println("x + y = " + engine.eval("x + y"));

        // 定义并调用函数
        engine.eval("function factorial(n) { return n <= 1 ? 1 : n * factorial(n-1); }");
        Invocable inv = (Invocable) engine;
        System.out.println("5! = " + inv.invokeFunction("factorial", 5));

        // 列出所有可用引擎
        System.out.println("\n可用引擎:");
        manager.getEngineFactories().forEach(f ->
                System.out.println("  " + f.getEngineName() + " [" + f.getLanguageName() + "]"));
    }
}
