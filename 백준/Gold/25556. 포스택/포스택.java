import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Stack<Integer>> stack = new ArrayList<>();
		boolean pushed = false;
		
		for (int i = 0; i < 4; i++) {
			stack.add(new Stack<Integer>());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pushed = false;
			for (Stack<Integer> A : stack) {
				if(!A.isEmpty() && num > A.peek()) {
					A.push(num);
					pushed = true;
					break;
				}else if(A.isEmpty()) {
					A.push(num);
					pushed = true;
					break;
				}
			}
			if (!pushed) {
				sb.append("NO\n");
				break;
			}
		}
		if(pushed) {
			sb.append("YES\n");
		}
		
		System.out.println(sb);
	}
}