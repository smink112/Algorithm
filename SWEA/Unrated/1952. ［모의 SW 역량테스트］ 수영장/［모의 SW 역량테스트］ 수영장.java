import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb;
    public static StringTokenizer st;

    static int Min;
    static int[] cost, month;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            cost = new int[4];
            Min = Integer.MAX_VALUE;
            cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            month = new int[12];
            month = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            recur(0, 0);
            if(Min > cost[3]) Min = cost[3];

            sb.append("#").append(test_case).append(" ").append(Min).append("\n");
        }
        System.out.println(sb);
    }

    static void recur(int n, int sum){
        if(n>=12) {
            if(Min > sum) Min = sum;
            return;
        }
        recur(n+1, sum+cost[0]*month[n]);
        recur(n+1, sum+cost[1]);
        recur(n+3, sum+cost[2]);
    }
}