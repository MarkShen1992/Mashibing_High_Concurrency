package com.basic.chapter1000;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new PaintFrame().launchFrame();
    }
}

class PaintFrame extends Frame {

    public void launchFrame() {
        setBounds(200, 200, 640, 480);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(50, 50, 30, 30);
        g.setColor(Color.green);
        g.fillRect(80, 80, 40, 40);
        g.setColor(c);
    }

}