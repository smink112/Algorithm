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
		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size() > 1) {
			q.poll();
			q.add(q.peek());
			q.poll();
		}
		
		System.out.println(q.peek());
	}
}