import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static int[][] dp;
	static int[][] Cost;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		dp = new int[N][3];
		Cost = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			Cost[i][0] = Integer.parseInt(st.nextToken()); // R
			Cost[i][1] = Integer.parseInt(st.nextToken()); // G
			Cost[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		
		dp[0][0] = Cost[0][0];
		dp[0][1] = Cost[0][1];
		dp[0][2] = Cost[0][2];
		
		
		int Min_Cost = Math.min(Paint(N-1,0), Math.min(Paint(N-1, 1), Paint(N-1,2)));
		
		System.out.println(Min_Cost);
	}

	public static int Paint(int N, int color) {
		if (dp[N][color] == 0) {

			if (color == 0) {
				dp[N][0] = Math.min(Paint(N - 1, 1), Paint(N - 1, 2)) + Cost[N][0];
			} else if (color == 1) {
				dp[N][1] = Math.min(Paint(N - 1, 0), Paint(N - 1, 2)) + Cost[N][1];
			} else {
				dp[N][2] = Math.min(Paint(N - 1, 0), Paint(N - 1, 1)) + Cost[N][2];
			}

		}

		return dp[N][color];
	}

}