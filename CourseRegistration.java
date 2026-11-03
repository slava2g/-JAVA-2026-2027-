package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseRegistration implements ActionListener {
    JLabel label;

    CourseRegistration() {
        JFrame frame = new JFrame("Реєстрація на курс");
        frame.setLayout(new FlowLayout());
        JButton registerButton = new JButton("Зареєструватися");
        registerButton.addActionListener(this);
        label = new JLabel("Натисніть кнопку для реєстрації.");
        frame.add(registerButton);
        frame.add(label);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        label.setText("Ви успішно зареєстровані на курс!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseRegistration::new);
    }
}