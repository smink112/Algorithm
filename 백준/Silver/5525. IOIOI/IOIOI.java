import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, count = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        char[] P = new char[2 * N + 1];
        P[0] = 'I';
        for (int i = 1; i <= 2 * N; i += 2) {
            P[i] = 'O';
            P[i + 1] = 'I';
        }

        char[] S = new char[M];
        S = br.readLine().toCharArray();
        for (int i = 0; i <= M - (2 * N + 1); i++) {
            if (S[i] == 'I') {
                int temp = 0;
                for (int j = 0; j < 2 * N + 1; j++) {
                    if (S[i + j] == P[j]) temp++;
                }
                if(temp == 2*N+1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}