package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import javax.swing.*;


public class Calculator extends JFrame implements ActionListener {
    static JTextField display;
    static String currentInput;

    public Calculator() { //gr 12 (constructor)
        currentInput = "";
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            
            button.addActionListener(this); //gr 12
            panel.add(button);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) == 'C') {
            currentInput = "";
            display.setText("");
        } 
        else if (command.charAt(0) == '=') {
            //update imports!
            //updae the pom.xml file as well!
            try {
                Expression expression = new ExpressionBuilder(currentInput).build();
                double result = expression.evaluate();
                display.setText(Double.toString(result));
                currentInput = "";
            } catch (Exception ex) {
                display.setText("Error");
                currentInput = "";
            }
        } 
        else {
            currentInput += command;
            display.setText(currentInput);
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
    }
}