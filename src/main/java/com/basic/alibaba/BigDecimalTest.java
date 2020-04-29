package com.basic.alibaba;

import java.math.BigDecimal;

/**
 * @description alibaba
 * @author shenjy
 * @since 2019/08/04
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);

        // 推荐使用
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
