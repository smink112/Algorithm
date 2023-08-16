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
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		int start = 1;
//		int end = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int end = Integer.parseInt(br.readLine());
			
			if(end >= start) {
				for(int j = start; j <= end; j++) {
					stack.push(j);
					sb.append("+\n");
//					System.out.println(j);
				}
				start = end+1;
			}
			else if(!stack.isEmpty() && stack.peek() != end) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb);
	}
}
