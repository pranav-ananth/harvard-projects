public class ArithmeticExpressionEvaluator {

    public ArithmeticExpressionEvaluator() {}

    public Double evaluate(String expression) {

        return evaluatePostfix(infixToPostfix(expression));
    }

    private String infixToPostfix(String expression) {

        String outputString = "";
        Stack<String> stack = new Stack<String>();
        String[] tokens = expression.split(" "); // Split by space to get individual tokens

        for (String token : tokens) {
            if (isNumeric(token)) {
                outputString += token + " ";
            }
            else if (isOperator(token)) {
                while (!stack.isEmpty() && ( getPrecedenceScore(token) < getPrecedenceScore(stack.peek()) || getPrecedenceScore(token) == getPrecedenceScore(stack.peek()) )) {
                    outputString += stack.pop() + " ";
                }
                stack.push(token);
            }
            else {
                throw new IllegalArgumentException("Invalid token in expression: " + token);
            }
        }

        while (!stack.isEmpty()) {
            outputString += stack.pop() + " ";
        }

        return outputString;
    }

    private int getPrecedenceScore(String s) {
        switch (s) {
            case "*":
            case "/":
                return 2;

            case "+":
            case "-":
                return 1;
        }
        return -1;
    }
    private Double evaluatePostfix(String expression) {
        Double returnValue = null;
        Stack<Double> stack = new Stack<Double>();
        String[] tokens = expression.split(" "); // Split by space to get individual tokens

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            }
            else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: Not enough operands for operator " + token);
                }
                double operand2 = stack.pop(); // Right operand
                double operand1 = stack.pop(); // Left operand
                double result = performOperation(operand1, operand2, token);
                stack.push(result);
            }
            else {
                throw new IllegalArgumentException("Invalid token in expression: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: Stack does not contain a single result.");
        }

        returnValue = stack.pop();
        return returnValue;
    }


    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
