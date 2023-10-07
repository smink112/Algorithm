import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, C, Max = 0;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int ans = 0;
        if (A == B && B == C) {
            ans = 10000 + A * 1000;
        } else if (A == B || A == C || B == C) {
            if(A == B || A == C){
                ans = 1000 + A * 100;
            } else {
                ans = 1000 + B * 100;
            }
        } else {
            Max = Math.max(A, Math.max(B, C));
            ans = Max * 100;
        }

        System.out.println(ans);

    }
}