package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentNameDemo implements ActionListener {
    JTextField nameField;
    JLabel label;

    StudentNameDemo() {
        JFrame frame = new JFrame("Введіть ім'я студента");
        frame.setLayout(new FlowLayout());
        nameField = new JTextField(10);
        nameField.addActionListener(this);
        label = new JLabel("Введіть ім'я студента: ");
        frame.add(label);
        frame.add(nameField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String studentName = nameField.getText();
        label.setText("Привіт, " + studentName + "!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentNameDemo::new);
    }
}