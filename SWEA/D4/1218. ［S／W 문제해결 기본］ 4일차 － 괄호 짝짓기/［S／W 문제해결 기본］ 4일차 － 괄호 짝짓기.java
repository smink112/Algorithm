import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == ')' && stack.peek() == '(') stack.pop();
				else if(arr[i] == ']' && stack.peek() == '[') stack.pop();
				else if(arr[i] == '}' && stack.peek() == '{') stack.pop();
				else if(arr[i] == '>' && stack.peek() == '<') stack.pop();
				else {
					stack.push(arr[i]);
				}
			}
			
			if(!stack.isEmpty()) {
				sb.append("#").append(test_case).append(" ").append(0).append("\n");
			}else {
				sb.append("#").append(test_case).append(" ").append(1).append("\n");
			}
		}
		System.out.println(sb);
	}
}