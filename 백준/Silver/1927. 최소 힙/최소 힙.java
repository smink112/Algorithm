import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0 && !q.isEmpty()) {
				sb.append(q.poll()).append("\n");
			}else if(temp == 0 && q.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				q.add(temp);
			}
		}
		
		System.out.println(sb);
	}
}