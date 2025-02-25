import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput;

    public Calculator() {
        currentInput = new StringBuilder();
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
            button.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) == 'C') {
            currentInput.setLength(0);
            display.setText("");
        } else if (command.charAt(0) == '=') {
            try {
                double result = evaluate(currentInput.toString());
                display.setText(Double.toString(result));
                currentInput.setLength(0);
            } catch (Exception ex) {
                display.setText("Error");
                currentInput.setLength(0);
            }
        } else {
            currentInput.append(command);
            display.setText(currentInput.toString());
        }
    }

    private double evaluate(String expression) {
        // Simple evaluation logic (not handling operator precedence)
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}