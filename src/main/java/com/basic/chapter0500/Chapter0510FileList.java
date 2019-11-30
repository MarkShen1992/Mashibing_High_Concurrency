package com.basic.chapter0500;

import java.io.*;

/**
 * windows 下 tree命令
 */
public class Chapter0510FileList {
    public static void main(String[] args) {
        File f = new File("d:/A");
        System.out.println(f.getName());
        tree(f, 1);
    }

    private static void tree(File f, int level) {
        String preStr = "";
        for (int i = 0; i < level; i++) {
            preStr += "    ";
        }

        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            System.out.println(preStr + childs[i].getName());
            if (childs[i].isDirectory()) {
                tree(childs[i], level + 1);
            }
        }
    }

}