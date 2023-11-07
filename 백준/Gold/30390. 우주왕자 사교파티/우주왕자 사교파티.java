import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long A, B, K, Ans = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());   //포도주
        B = Long.parseLong(st.nextToken());   //빵
        K = Long.parseLong(st.nextToken());   //가능한 마법 횟수

        long sum = A + B;

        if (Math.min(A, B) <= K) {
            Ans = sum;
        } else {
            for (int i = 1; i < (int) Math.sqrt(sum) + 1; i++) {
                if (sum % i == 0) {
                    if ((A % i <= K || A % i >= i - K) && (B % i <= K || B % i >= i - K)) {
                        Ans = Math.max(Ans, i);
                    }
                }
                long temp = sum / i;
                if (sum % temp == 0) {
                    if ((A % temp <= K || A % temp >= temp - K) && (B % temp <= K || B % temp >= temp - K))
                        Ans = Math.max(Ans, temp);
                }
            }
        }
        System.out.println(Ans);
    }
}