package com.program;

import java.util.Random;

/**
 * Code 生成器
 */
public class CodeGenerator {
    private static String elements = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateCode(int codeLength) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        if (codeLength <= 0)
            return "";
        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(elements.length());
            code.append(elements.charAt(index));
        }
        return code.toString();
    }

    /**
     * https://dzone.com/articles/java-string-format-examples
     *
     * @param digits 位数
     * @param val 值
     * @return
     */
    public static String convert(int digits, int val) {
        StringBuilder sb = new StringBuilder();
        sb.append("%0").append(digits).append("d");
        return String.format(sb.toString(), val);
    }

    public static void main(String[] args) {
        System.out.println(generateCode(4));
        System.out.println(convert(10, 1));
    }
}
