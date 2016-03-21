import java.util.Stack;
import static java.lang.Double.parseDouble;

public class Evaluate{
    public static double caculate(String expression) {
        Stack<String> operator = new Stack<String>();
        Stack<Double> number = new Stack<Double>();
        for (int i = 0; i < expression.length(); i++) {
            String current = i == expression.length() - 1 ? expression.substring(i) : expression.substring(i, i + 1);
            if (!current.equals("(")) {
                if (!current.equals(")")) {
                    if (Character.isDigit(current.charAt(0))) {
                        number.push(parseDouble(current));
                    } else {
                        operator.push(current);
                    }
                } else {
                    String currentOperator = operator.pop();
                    double currentNumber1 = number.pop();
                    double currentNumber2 = number.pop();
                    double result = 0;
                    switch (currentOperator) {
                        case "+":
                            result = currentNumber1 + currentNumber2;
                            break;
                        case "-":
                            result = currentNumber1 - currentNumber2;
                            break;
                        case "*":
                            result = currentNumber1 * currentNumber2;
                            break;
                        case "/":
                            result = currentNumber1 * currentNumber2;
                            break;
                        default:
                            break;
                    }
                    number.push(result);
                }
            }
        }
        return number.pop();
    }
}
