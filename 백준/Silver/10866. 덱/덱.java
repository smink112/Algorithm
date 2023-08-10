import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;

			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;

			case "front":
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(dq.getFirst()).append("\n");
				}
				break;

			case "back":
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(dq.getLast()).append("\n");
				}
				break;

			case "size":
//				if (dq.isEmpty()) {
//					sb.append(0).append("\n");
//				}else {
//					sb.append(dq.size()).append("\n");
//				}
				sb.append(dq.size()).append("\n");
				break;

			case "empty":
				if (dq.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "pop_front":
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(dq.getFirst()).append("\n");
					dq.removeFirst();
				}
				break;
				
			case "pop_back":
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(dq.getLast()).append("\n");
					dq.removeLast();
				}
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}
}