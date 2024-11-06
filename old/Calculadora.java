import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Calculadora {
    private JFrame frame;
    private JTextField display;
    private List<JButton> buttonList;

    public static void main(String[] args) {
        new Calculadora().inicializar();
    }

    public void inicializar() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        frame.add(panel, BorderLayout.CENTER);

        criarBotoes(panel);
        frame.setVisible(true);
    }

    private void criarBotoes(JPanel panel) {
        buttonList = new ArrayList<>();
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonActionListener());
            buttonList.add(button);
            panel.add(button);
        }
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String command = button.getText();
            switch (command) {
                case "C":
                    display.setText("");
                    break;
                case "=":
                    try {
                        double result = evaluate(display.getText());
                        display.setText(String.valueOf(result));
                    } catch (Exception ex) {
                        display.setText("Erro");
                    }
                    break;
                default:
                    display.setText(display.getText() + command);
                    break;
            }
        }
    }

    private double evaluate(String expression) {
        try {
            List<String> postfix = infixToPostfix(expression);
            return evaluatePostfix(postfix);
        } catch (Exception e) {
            throw new RuntimeException("Erro na avaliação da expressão");
        }
    }

    private List<String> infixToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        StringBuilder number = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    output.add(number.toString());
                    number.setLength(0);
                }

                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(String.valueOf(ch))) {
                        output.add(operators.pop());
                    }
                    operators.push(String.valueOf(ch));
                }
            }
        }

        if (number.length() > 0) {
            output.add(number.toString());
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b != 0) {
                            stack.push(a / b);
                        } else {
                            throw new ArithmeticException("Divisão por zero.");
                        }
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}