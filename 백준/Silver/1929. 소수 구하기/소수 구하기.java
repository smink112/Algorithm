import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] A;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        A = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (A[i] == 0) continue;
            for (int j = 2 * i; j <= n; j += i) {
                A[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (A[i] != 0)
                System.out.println(A[i]);
        }

    }
}
