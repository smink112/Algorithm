import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int N;
	static int[] stair;
	static int max = Integer.MIN_VALUE;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		stair = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stair[0];
		dp[1] = stair[1];

		if(N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		
		System.out.println(GetScore(N));
	}

	static int GetScore(int idx) {
		if (dp[idx] == 0 && idx != 0) {
			dp[idx] = Math.max(GetScore(idx - 2), GetScore(idx - 3) + stair[idx - 1]) + stair[idx];
		}

		return dp[idx];
	}
}