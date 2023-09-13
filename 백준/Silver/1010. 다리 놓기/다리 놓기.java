import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[30][30];
			
			
			sb.append(combination(M,N)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int combination(int n, int r) {
//		if(dp[n][r] == 0) {
//			dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
//		}
//		if(n == r || r == 0) {
//			dp[n][r] = 1;
//		}
//		return dp[n][r];
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}