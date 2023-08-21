import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int dist = Y-X;
			
			int max = (int)Math.sqrt(dist);
			
			if(max == Math.sqrt(dist)) {
				sb.append(max * 2 - 1).append("\n");
			}
			else if(dist <= max * (max + 1)) {
				sb.append(max * 2).append("\n");
			}
			else {
				sb.append(max * 2 + 1).append("\n");
			}
			
		}
		System.out.println(sb);
	}
}