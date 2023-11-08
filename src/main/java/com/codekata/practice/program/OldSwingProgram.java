package com.codekata.practice.program;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The type Old swing program.
 */
public class OldSwingProgram {

    /**
     * Instantiates a new Old swing program.
     */
    public OldSwingProgram() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        jFrame.setFocusable(true);

        JPanel jPanel = new JPanel();
        JLabel up = new JLabel();
        JLabel down = new JLabel();
        JLabel left = new JLabel();
        JLabel right = new JLabel();

        up.setText("UP: 0");
        down.setText("DOWN: 0");
        left.setText("LEFT: 0");
        right.setText("RIGHT: 0");

        jPanel.add(up);
        jPanel.add(down);
        jPanel.add(left);
        jPanel.add(right);

        jFrame.addKeyListener(new KeyListener() {

            int upCount = 0;
            int downCount = 0;
            int leftCount = 0;
            int rightCount = 0;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        up.setText("UP: " + upCount++);
                        break;
                    case KeyEvent.VK_DOWN:
                        down.setText("DOWN: " + downCount++);
                        break;
                    case KeyEvent.VK_LEFT:
                        left.setText("LEFT: " + leftCount++);
                        break;
                    case KeyEvent.VK_RIGHT:
                        right.setText("RIGHT: " + rightCount++);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        jFrame.add(jPanel);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new OldSwingProgram();
    }


}
