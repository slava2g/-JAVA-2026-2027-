package org.example;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderLayoutApp::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("BorderLayout Програма");
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("Північ"), BorderLayout.NORTH);
        frame.add(new JButton("Південь"), BorderLayout.SOUTH);
        frame.add(new JButton("Схід"), BorderLayout.EAST);
        frame.add(new JButton("Захід"), BorderLayout.WEST);
        frame.add(new JButton("Центр"), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}