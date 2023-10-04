import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S1 = br.readLine();
        String S2 = br.readLine();

        char[] cArr1 = S1.toCharArray();
        char[] cArr2 = S2.toCharArray();

        int[][] dp = new int[cArr1.length + 1][cArr2.length + 1];

        for(int i = 1; i <= cArr1.length; i++) {
            for(int j = 1; j <= cArr2.length; j++) {
                // 만일 두 문자가 같은 경우
                if(cArr1[i-1] == cArr2[j-1]) {
                    // 대각선의 값을 참고하여 LCS의 값을 + 1한다.
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 두 문자가 다른 경우
                else {
                    // 각 문자열의 이전 문자 중 최대 LCS값을 선택.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[S1.length()][S2.length()]);
    }
}