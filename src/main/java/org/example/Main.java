package org.example;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Main extends JFrame {

    JLabel title, q1, q2, q3;
    JTextField a1, a2, a3;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 500));
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("rollercoaster safety check");
        this.getContentPane().setBackground(new Color(0x3E84C2));

        title = new JLabel("rollercoaster safety check", JLabel.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 26));
        title.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xB093E0), 4, true),
                "welcome to",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14),
                new Color(0xebddff)));
        title.setForeground(Color.white);

        q1 = new JLabel("Height in CM:");






        this.add(title);
        title.setBounds(170, 20, 360, 75);

        this.add(q1);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}