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
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0 && !stack.isEmpty()) {
				stack.remove(stack.size()-1);
			}else {
				stack.add(num);
			}
		}
		
		int sum = 0, temp = stack.size();
		for (int i = 0; i < temp; i++) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}