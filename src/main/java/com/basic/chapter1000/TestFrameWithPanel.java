package com.basic.chapter1000;

import java.awt.*;

public class TestFrameWithPanel {
    public static void main(String args[]) {
        Frame f = new Frame("MyTest Frame");
        Panel pan = new Panel();
        f.setSize(200, 200);
        f.setBackground(Color.blue);
        f.setLayout(null);
        pan.setSize(100, 100);
        pan.setBackground(Color.green);
        f.add(pan);
        f.setVisible(true);
    }
}