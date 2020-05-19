package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;

public class TestKey {
    public static void main(String[] args) {
        new KeyFrame().launchFrame();
    }
}

class KeyFrame extends Frame {
    public void launchFrame() {
        setSize(200, 200);
        setLocation(300, 300);
        addKeyListener(new MyKeyMonitor());
        setVisible(true);
    }

    class MyKeyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                System.out.println("UP");
            }
        }
    }
}
