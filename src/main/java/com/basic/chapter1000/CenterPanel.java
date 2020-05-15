package com.basic.chapter1000;

import java.awt.*;

public class CenterPanel {
    public static void main(String args[]) {
        new MyFrame3(300, 300, 400, 300, Color.BLUE);
    }
}

class MyFrame3 extends Frame {
    private Panel p;

    MyFrame3(int x, int y, int w, int h, Color c) {
        super("FrameWithPanel");
        setLayout(null);
        setBounds(x, y, w, h);
        setBackground(c);
        p = new Panel(null);
        p.setBounds(w / 4, h / 4, w / 2, h / 2);
        p.setBackground(Color.YELLOW);
        add(p);
        setVisible(true);
    }
}
