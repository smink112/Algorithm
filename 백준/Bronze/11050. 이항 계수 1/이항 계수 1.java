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
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		System.out.println(binomial(N,K));
		
	}

	static int[][] dp;

	static int binomial(int N, int K) {
		if(dp[N][K] > 0) {
			return dp[N][K];
		}
		if(N == K || K == 0) {
			return dp[N][K] = 1;
		}
		return dp[N][K] = binomial(N - 1, K - 1) + binomial(N - 1, K);
	}
}