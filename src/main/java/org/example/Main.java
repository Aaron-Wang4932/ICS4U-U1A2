package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.tools.Tool;

public class Main extends JFrame implements ActionListener, KeyListener {

    JLabel title, question1, question2, question3;
    JTextField ans1;
    JComboBox<String> ans2, ans3;
    String[] choices = {"YES", "NO"};

    JTextArea output;
    JButton submit;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 500));
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("rollercoaster safety check");
        this.getContentPane().setBackground(new Color(0x3E84C2));

        title = new JLabel("rollercoaster safety check", JLabel.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
        title.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xB093E0), 4, true),
                "welcome to",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16),
                new Color(0xebddff)));
        title.setForeground(Color.white);

        question1 = new JLabel("Height in CM:");
        question1.setFont(new Font("Century Gothic", Font.BOLD, 20));
        question1.setForeground(Color.white);
        //question1.setBorder(BorderFactory.createLineBorder(Color.black));

        question2 = new JLabel("Back Trouble?");
        question2.setFont(new Font("Century Gothic", Font.BOLD, 20));
        question2.setForeground(Color.white);
        //question2.setBorder(BorderFactory.createLineBorder(Color.black));

        question3 = new JLabel("Heart Trouble?");
        question3.setFont(new Font("Century Gothic", Font.BOLD, 20));
        question3.setForeground(Color.white);
        //question3.setBorder(BorderFactory.createLineBorder(Color.black));

        ans1 = new JTextField();
        ans1.setFont(new Font("Century Gothic", Font.BOLD, 20));
        ans1.setMargin(new Insets(0, 3, 0, 3));
        ans1.addKeyListener(this);

        ans2 = new JComboBox<>(choices);
        ans2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        ans2.setFocusable(false);

        ans3 = new JComboBox<>(choices);
        ans3.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        ans3.setFocusable(false);

        output = new JTextArea("Enter your information and press submit!");
        output.setEditable(false);
        output.setFocusable(false);
        output.setFont(new Font("Century Gothic", Font.BOLD, 18));
        output.setMargin(new Insets(5, 5, 5, 5));

        submit = new JButton("Submit Info");
        submit.setFocusable(false);
        submit.setFont(new Font("Century Gothic", Font.BOLD, 18));
        submit.addActionListener(this);

        this.add(title);
        title.setBounds(130, 20, 440, 75);

        this.add(question1);
        question1.setBounds(130, 125, 150, 30);

        this.add(ans1);
        ans1.setBounds(420, 125, 150, 30);

        this.add(question2);
        question2.setBounds(130, 185, 150, 30);

        this.add(ans2);
        ans2.setBounds(420, 185, 150, 30);

        this.add(question3);
        question3.setBounds(130, 245, 150, 30);

        this.add(ans3);
        ans3.setBounds(420, 245, 150, 30);

        this.add(output);
        output.setBounds(130, 305, 440, 40);

        this.add(submit);
        submit.setBounds(275,365, 150, 35);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = ans1.getText();
        double height;
        try{
            height = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            output.setText("Enter a valid height!");
            return;
        }

        if(height > 122 &&
           height < 188 &&
           ans2.getSelectedIndex() == 1 &&
           ans3.getSelectedIndex() == 1) {
            output.setText("You are eligible to ride the rollercoaster!");
        } else output.setText("You are NOT eligible to ride the rollercoaster!");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
            e.consume();
            if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}