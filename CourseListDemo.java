package org.example;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class CourseListDemo implements ListSelectionListener {
    JList<String> courseList;
    JLabel selectedLabel;

    CourseListDemo() {
        JFrame frame = new JFrame("Вибір курсу");
        frame.setLayout(new FlowLayout());
        String[] courses = {"Програмування", "Алгоритми", "Мережі"};
        courseList = new JList<>(courses);
        courseList.addListSelectionListener(this);
        selectedLabel = new JLabel("Вибрано курс: ");
        frame.add(new JScrollPane(courseList));
        frame.add(selectedLabel);
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            selectedLabel.setText("Вибрано курс: " + courseList.getSelectedValue());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseListDemo::new);
    }
}