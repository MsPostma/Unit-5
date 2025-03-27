package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame implements ActionListener {
    static JTextField display;
    static String currentInput;

    static double firstNum;
    static double secondNum;
    static String operation;

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
            
            //search for the operation
            for(int i = 0; i<currentInput.length(); i++){
                Character currentChar = currentInput.charAt(i);
                if(!Character.isDigit(currentChar)){
                    if(currentChar!='.'){
                        operation = currentChar + "";
                        firstNum = Double.parseDouble(currentInput.substring(0, i));
                        secondNum = Double.parseDouble(currentInput.substring(i+1));
                    }
                }
            }

            if(operation.equals("+")){
                double result = firstNum + secondNum;
                display.setText(result + "");
            }
            else if(operation.equals("-")){
                double result = firstNum - secondNum;
                display.setText(result + "");
            }
            //implement the other operations
            
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