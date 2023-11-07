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
        B = A/4;

        for (int i = 0; i < B; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}