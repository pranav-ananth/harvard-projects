public class Tester {
    public static void main(String[] args) {
        ArithmeticExpressionEvaluator evaluator = new ArithmeticExpressionEvaluator();
        String infixExpression1 = "10 + 2 * 8 - 3";
        System.out.println("The value of the infix expression " + infixExpression1 + " = " + evaluator.evaluate(infixExpression1));

        String infixExpression2 = "8 + 12 + 4 * 4 / 2";
        System.out.println("The value of the infix expression " + infixExpression2 + " = " + evaluator.evaluate(infixExpression2));

        String infixExpression3 = "4 / 3 + 2 - 2";
        System.out.println("The value of the infix expression " + infixExpression3 + " = " + evaluator.evaluate(infixExpression3));
    }
}
