package com.basic.alibaba;

/**
 * @author MarkShen1992
 * @since 2020.4.29
 */
public class ConfusingName {
    public int stock;
    private boolean condition;

    // 非 setter/getter 的参数名称，不允许与本类成员变量同名
    public void get(String alibaba) {
        if (condition) {
            final int money = 666;
        }
        for (int i = 0; i < 10; i++) {
            // 在同一方法体中，不允许与其它代码块中的 money 命名相同
            final int money = 15978;
        }
    }
}

class Son extends ConfusingName {
    public int stock;
}
