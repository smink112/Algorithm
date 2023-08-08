import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int sum = 1, result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
				sum *= 2;
			} else if (s.charAt(i) == '[') {
				stack.push(s.charAt(i));
				sum *= 3;
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				} else if (s.charAt(i-1) == '(') {
					result += sum;
				}
				stack.pop();
				sum /= 2;
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				} else if (s.charAt(i-1) == '[') {
					result += sum;
				}
				stack.pop();
				sum /= 3;
			}
		}
		if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");
		
        System.out.println(sb);
	}
}
