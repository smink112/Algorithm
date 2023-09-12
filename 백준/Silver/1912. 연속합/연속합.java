import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	static int N, max;
	static Integer[] dp;
	static int[] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		map = new int[N];
		dp = new Integer[N];

		map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		dp[0] = map[0];
		max = map[0];

		recursion(N - 1);

		System.out.println(max);
	}

	static int recursion(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(recursion(n - 1) + map[n], map[n]);
			max = Math.max(dp[n], max);
		}

		return dp[n];
	}
}