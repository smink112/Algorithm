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

		while (true) {
			String s = br.readLine();
			if (s.equals(".")) {
				break;
			}
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.add(s.charAt(i));
				} else if (s.charAt(i) == '[') {
					stack.add(s.charAt(i));
				} else if (s.charAt(i) == ')') {
					if ((!stack.isEmpty() && stack.peek() != '(') || stack.isEmpty()) {
						flag = false;
						break;
					} else if (!stack.isEmpty()) {
						stack.pop();
					}
				} else if (s.charAt(i) == ']') {
					if ((!stack.isEmpty() && stack.peek() != '[') || stack.isEmpty()) {
						flag = false;
						break;
					} else if (!stack.isEmpty()) {
						stack.pop();
					}
				}
			}

			if (flag && stack.isEmpty()) {
				sb.append("yes\n");
			} else if(!flag || !stack.isEmpty()){
				sb.append("no\n");
			}
		}
		
		System.out.println(sb);
	}
}