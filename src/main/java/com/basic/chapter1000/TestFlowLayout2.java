package com.basic.chapter1000;

import java.awt.*;

public class TestFlowLayout2 {
    public static void main(String args[]) {
        Frame f = new Frame("Java Frame");
        FlowLayout l = new FlowLayout(FlowLayout.CENTER, 20, 40);
        f.setLayout(l);
        f.setLocation(300, 400);
        f.setSize(300, 200);
        f.setBackground(new Color(204, 204, 255));
        for (int i = 1; i <= 7; i++) {
            f.add(new Button("BUTTON"));
        }
        f.setVisible(true);
    }
}
