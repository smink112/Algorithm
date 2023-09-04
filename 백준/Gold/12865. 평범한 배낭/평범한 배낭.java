import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int N, W;
	static int[][] stuff;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		stuff = new int[N][2]; // 0 : 무게, 1 : 가치
		dp = new Integer[N][W + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Bag(N-1,W));
	}

	static int Bag(int i, int k) { // i : 담을 물건 idx, k : 담겨져있는 무게
		if (i < 0)
			return 0;

		if (dp[i][k] == null) {
			if (stuff[i][0] > k) {
				dp[i][k] = Bag(i - 1, k);
			} else {
				dp[i][k] = Math.max(Bag(i-1,k), Bag(i-1,k-stuff[i][0]) + stuff[i][1]); 
			}

		}
		return dp[i][k];
	}
}