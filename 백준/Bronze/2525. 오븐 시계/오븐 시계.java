import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, C;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        C = Integer.parseInt(br.readLine());

        B += C;
        if(B>=60){
            A += B/60;
            B %= 60;
        }

        System.out.println(A%24 + " " + B);
    }
}