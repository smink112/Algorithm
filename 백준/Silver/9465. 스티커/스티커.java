import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static Integer[][] dp;
    static int[][] map;
    static int N, Max;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[2][N+1];
            dp = new Integer[2][N+1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            Max = Math.max(recursion(0, N),recursion(1,N));
            sb.append(Max).append("\n");
        }

        System.out.println(sb);
    }

    static int recursion(int r, int c) {
        if (dp[r][c] != null)
            return dp[r][c];
        if(r == 0){
            dp[r][c] = Math.max(recursion(1,c-1),recursion(1,c-2)) + map[r][c];
        }else{
            dp[r][c] = Math.max(recursion(0,c-1),recursion(0,c-2)) + map[r][c];
        }

        return dp[r][c];
    }
}