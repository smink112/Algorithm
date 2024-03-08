import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];    // 해당 숫자가 될 수 있는 최소 개수를 저장한다.
        dp[1] = 1;  // 1 = 1^2 ->  1개

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            // 제곱수가 i보다 작은 dp[i - j * j] 중 최소를 택한다.
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1; // 그리고 1을 더해준다.
        }

        System.out.println(dp[N]);

    }
}