import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, Max = 0;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		dp = new int[N];

//		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < N; i++) {
			DP(i);
		}

		for (int i = 0; i < N; i++) {
			Max = Math.max(Max, dp[i]);
		}

		System.out.println(Max);
	}

	static int DP(int n) {
		if (dp[n] == 0) {
			dp[n] = 1;
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], DP(i) + 1);
				}
			}
		}

		return dp[n];
	}
}