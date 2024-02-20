import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int bucket[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            bucket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tempArr[] = new int[b - a + 1];

            for (int j = 0; j <= b-a; j++) {
                tempArr[j] = bucket[j+a];
            }

            for (int j = 0; j <= b-a ; j++) {
                bucket[j+a] = tempArr[b-a-j];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ",bucket[i]);
        }

    }
}