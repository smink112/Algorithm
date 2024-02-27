import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < 2* i -1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < 2* i -1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}