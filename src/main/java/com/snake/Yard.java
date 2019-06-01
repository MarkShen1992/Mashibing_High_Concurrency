package com.snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {

    public static final int NODE_SIZE = 15; // 格子大小
    public static final int NODE_COUNT = 30; // 格子数量
    public static final int AREA_WIDTH = NODE_SIZE * NODE_COUNT;

    // 格子左上角点的坐标
    public static int x = AREA_WIDTH / 2;
    public static int y = AREA_WIDTH / 2;

    private Egg e = new Egg(10, 10);
    private Snake s = new Snake();

    public Yard() {
        this.setSize(2 * AREA_WIDTH, 2 * AREA_WIDTH);
        this.setVisible(Boolean.TRUE);
        // 添加关闭按钮事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                s.keyPressed(e);
            }
        });

        // repaint
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    /**
     * 画出小蛇跑的区域
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);

        for (int i = 0; i <= NODE_COUNT; i ++) {
            // 画横线
            g.drawLine(x, y + NODE_SIZE * i, x + AREA_WIDTH, y + NODE_SIZE * i);
            // 画纵线
            g.drawLine(x + NODE_SIZE * i, y, x + NODE_SIZE * i, y + AREA_WIDTH);
        }

        s.paint(g);
        e.paint(g);
        s.eat(e);
        // 保持现场
        g.setColor(c);
    }

    // 双缓冲
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(this.getWidth(), this.getHeight());
        }
        Graphics gOff = offScreenImage.getGraphics();
        print(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        new Yard();
    }
}
