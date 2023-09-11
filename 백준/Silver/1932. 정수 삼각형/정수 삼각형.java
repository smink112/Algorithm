import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	static int N;
	static Integer[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		dp = new Integer[N][N];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp값 초기화
		for (int i = 0; i < N; i++) {
			dp[N-1][i] = map[N-1][i];
		}
		
		System.out.println(find(0,0));

	}

	static int find(int depth, int index) {
		if (depth == N - 1)
			return dp[depth][index];

		if (dp[depth][index] == null) {
			dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + map[depth][index];
		}

		return dp[depth][index];
	}
}