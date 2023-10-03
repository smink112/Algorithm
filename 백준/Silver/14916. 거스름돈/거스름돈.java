import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        if(N<=5) {
            if(N==2) System.out.println(1);
            else if (N==4) System.out.println(2);
            else if (N==5) System.out.println(1);
            else System.out.println(-1);
            return;
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 100001);
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            //3원 짜리를 써서 지금의 금액이 되는 경우와
            //5원 짜리를 써서 지금의 금액이 되는 경우
            //두가지를 비교해서 더 적은 횟수가 지금 dp[금액]의 값
            dp[i] = Math.min(dp[i-2]+1, dp[i-5]+1);
        }
        if(dp[N] > 100001) {
            System.out.println(-1);
        }else {
            System.out.println(dp[N]);
        }
    }
}