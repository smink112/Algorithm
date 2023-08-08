import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
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
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> answer = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int temp = 0;
			for (int i = 1; i < K; i++) {
				temp = queue.poll();
				queue.add(temp);
			}
			answer.add(queue.poll());
		}
		System.out.println(answer.toString().replaceAll("\\[", "<").replaceAll("]", ">"));
	}
}
