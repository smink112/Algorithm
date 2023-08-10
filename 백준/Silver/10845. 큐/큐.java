import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		ArrayList<Integer> q = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;

			case "front":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(q.get(0)).append("\n");
				}
				break;

			case "back":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(q.get(q.size()-1)).append("\n");
				}
				break;

			case "size":
				sb.append(q.size()).append("\n");
				break;

			case "empty":
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "pop":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(q.get(0)).append("\n");
					q.remove(0);
				}
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}
}