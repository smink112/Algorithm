import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
//    static int[] coin;
    static int[] dp;
    static ArrayList<Integer> coin = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        Arrays.fill(dp, 10001);

        for (int i = 0; i < N; i++) {
//            coin[i] = Integer.parseInt(br.readLine());
            int temp = Integer.parseInt(br.readLine());
            if (temp <= K) {
                coin.add(temp);
                dp[temp] = 1;

                for (int k = temp + 1; k < dp.length; k++) {
                    int Min = 10001;
                    for (int j = 0; j < coin.size(); j++) {
                        if (k - coin.get(j) >= 0)
                            Min = Math.min(Min, dp[k - coin.get(j)] + 1);
                    }

                    dp[k] = Math.min(Min,dp[k]);
                }
            }
        }

        System.out.println(dp[K] == 10001 ? -1 : dp[K]);

    }

}