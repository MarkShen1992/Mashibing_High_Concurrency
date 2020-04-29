package com.basic.alibaba;

/**
 * @description alibaba
 * @author shenjy
 * @since 2019/08/04
 */
public class FloatWrapTest {
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
