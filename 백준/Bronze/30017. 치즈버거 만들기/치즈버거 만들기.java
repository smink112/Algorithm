import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 0;

        if (B >= A) {
            count = A + (A - 1);
        } else if (A > B) {
            count = (B + 1) + B;
        }

        System.out.printf("%d", count);
    }
}
