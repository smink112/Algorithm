import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int M, N, x, y, TC;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            boolean flag = false;

            for (int i = x; i <= M * N; i += M) {
                if (i % M == x && i % N == y) {
                    System.out.println(i + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1);
            }
        }

    }
}