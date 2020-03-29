import java.util.Stack;
import java.util.regex.Pattern;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//        Valid operators are+,-,*,/. Each operand may be an integer or another expression.
public class Polish {
    public static void main(String[] args) {
        String[] test = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(new Polish().evalRPN(test));
    }

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for(String input : tokens){
            if(Pattern.matches("\\W",input)){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = 0;
                switch (input){
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                stack.push(String.valueOf(result));
                continue;
            }
            stack.push(input);
        }
        return Integer.parseInt(stack.pop());
    }
}
