package com.snake;

import java.awt.*;

/**
 * 双向链表
 */
public class Node {
    int row, col;
    Node pre, next;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void paint(Graphics g) {
        int x = Yard.x + col * Yard.NODE_SIZE;
        int y = Yard.y + row * Yard.NODE_SIZE;

        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x, y, Yard.NODE_SIZE, Yard.NODE_SIZE);

        // 恢复现场
        g.setColor(c);
    }
}
