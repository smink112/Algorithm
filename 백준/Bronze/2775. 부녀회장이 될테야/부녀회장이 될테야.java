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
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apartment = new int[k+1][n];
			
			for (int i = 0; i < n; i++) {
				apartment[0][i] = i+1;
			}
			
			for(int i = 1; i <= k;i++) {	//1층부터 시작
				for (int j = 0; j < n; j++) {
					for(int a = 0; a <= j; a++) {
						apartment[i][j] += apartment[i-1][a];
					}
				}
			}
			sb.append(apartment[k][n-1]).append("\n");
		}
		System.out.println(sb);
	}
}