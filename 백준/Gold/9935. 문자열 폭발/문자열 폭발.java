import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			stack.add(s.charAt(i));
			
			if(stack.size() >= bomb.length()) {
				boolean flag = true;
				for (int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {	//일치하면 bomb길이만큼 스택 팝
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
			
		}
		sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}