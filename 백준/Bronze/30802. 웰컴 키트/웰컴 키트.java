import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, T, P;
    static int[] size = new int[6];
    static int count = 0;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 6; i++) {
            if (size[i] % T != 0) {
                count += size[i] / T + 1;
            } else {
                count += size[i] / T;
            }
        }

        System.out.println(count);
        System.out.println(N / P + " " + N % P);
    }
}