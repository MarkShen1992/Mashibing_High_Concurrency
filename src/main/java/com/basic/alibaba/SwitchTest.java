package com.basic.alibaba;

/**
 * @description alibaba
 * @author shenjy
 * @since 2019/08/04
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
