import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, C, Max = 0;


    public static void main(String[] args) throws IOException {
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            ans += cost * n;
        }

        System.out.println(A == ans ? "Yes" : "No");

    }
}