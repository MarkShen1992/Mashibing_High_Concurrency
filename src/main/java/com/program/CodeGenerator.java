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

    public static void main(String[] args) {
        System.out.println(generateCode(4));
    }
}
