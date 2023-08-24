import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static int[][] map;
	static int N, count;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
				dp[i][j][2] = -1;
			}
		}
		dp[0][1][0] = 1;
		dp[0][1][1] = 0;
		dp[0][1][2] = 0;

		long sum = Route(N - 1, N - 1, 0) + Route(N - 1, N - 1, 1) + Route(N - 1, N - 1, 2);

		System.out.println(sum);
	}

	static long Route(int r, int c, int dir) {
		if (map[r][c] == 1) {
			dp[r][c][dir] = 0;
			return dp[r][c][dir];
		}

		if (dp[r][c][dir] == -1) {
				dp[r][c][dir] = 0;
			
			if (dir == 0 && c - 1 >= 0 && map[r][c - 1] != 1) {
				long temp1 = Route(r, c - 1, 0);
				long temp2 = Route(r, c - 1, 2);
				dp[r][c][dir] = (temp1 == -1? 0 : temp1) + (temp2 == -1? 0 : temp2);
			}

			if (dir == 1 && r - 1 >= 0 && map[r - 1][c] != 1) {
				long temp1 = Route(r-1, c, 1);
				long temp2 = Route(r-1, c, 2);
				dp[r][c][dir] = (temp1 == -1? 0 : temp1) + (temp2 == -1? 0 : temp2);

			}

			if (dir == 2 && r - 1 >= 0 && c - 1 >= 0 && map[r - 1][c] != 1 && map[r][c - 1] != 1) {
				long temp1 = Route(r - 1, c - 1, 0);
				long temp2 = Route(r - 1, c - 1, 1);
				long temp3 = Route(r - 1, c - 1, 2);
				dp[r][c][dir] = (temp1 == -1? 0 : temp1) + (temp2 == -1? 0 : temp2) + (temp3 == -1? 0 : temp3);
			}
		}
		return dp[r][c][dir];
	}
}