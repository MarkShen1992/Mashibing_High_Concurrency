package com.basic.chapter1000;

import java.awt.*;

public class TenButtons {
    public static void main(String args[]) {
        Frame f = new Frame("Java Frame");
        f.setLayout(new GridLayout(2, 1));
        f.setLocation(300, 400);
        f.setSize(300, 200);
        f.setBackground(new Color(204, 204, 255));
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new BorderLayout());
        Panel p11 = new Panel(new GridLayout(2, 1));
        Panel p21 = new Panel(new GridLayout(2, 2));
        p1.add(new Button("BUTTON"), BorderLayout.WEST);
        p1.add(new Button("BUTTON"), BorderLayout.EAST);
        p11.add(new Button("BUTTON"));
        p11.add(new Button("BUTTON"));
        p1.add(p11, BorderLayout.CENTER);
        p2.add(new Button("BUTTON"), BorderLayout.WEST);
        p2.add(new Button("BUTTON"), BorderLayout.EAST);
        for (int i = 1; i <= 4; i++) {
            p21.add(new Button("BUTTON"));
        }
        p2.add(p21, BorderLayout.CENTER);
        f.add(p1);
        f.add(p2);
        f.setVisible(true);
    }
}
