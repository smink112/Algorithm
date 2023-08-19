import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Integer[] dp = new Integer[1001];

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(makeSquare(N));

	}

	public static int makeSquare(int N) {
		if (dp[N] == null) {
			dp[N] = (makeSquare(N - 1) + makeSquare(N - 2)) % 10007;

		}

		return dp[N];
	}
}