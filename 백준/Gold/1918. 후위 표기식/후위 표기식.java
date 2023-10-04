import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char idx = s.charAt(i);

            switch (idx){
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(idx)) {
                        sb.append(stack.pop());
                    }
                    stack.add(idx);
                    break;
                case '(' :
                    stack.add(idx);
                    break;
                case ')' :
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(idx);
            }

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static int priority(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.
    }
}