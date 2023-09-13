import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	static int N;
	static Long[] dp;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			dp = new Long[N];
			if(N<3) {
				for (int i = 0; i < N; i++) {
					dp[i] = 1L;
				}
			}else {
				for (int i = 0; i < 3; i++) {
					dp[i] = 1L;
				}
			}
			
			sb.append(recursion(N-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	static Long recursion(int n) {
		if(dp[n] == null) {
			dp[n] = recursion(n-2) + recursion(n-3);
		}
		
		return dp[n];
	}
}