import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int j = 0; j < N; j++) {
			String s = br.readLine();
			int score = 0,count = 0;
			
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'O') {
					count++;
				}else {
					count = 0;
				}
				score += count;
			}
			
			sb.append(score).append("\n");
		}
		System.out.println(sb);
	}
}
