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

        char[] S = br.readLine().toCharArray();
        int pattern = 0;
        for (int i = 1; i <M-1; i++) {
            if(S[i-1]=='I' && S[i]=='O' && S[i+1]=='I'){
                pattern++;
                if(pattern == N){
                    pattern--;  //다음 i에서 IOI가 한번 더 발견되면 또 해당될 수 있게끔
                    count++;
                }
                i++;
            }
            else {  //한번이라도 패턴이 끊기면
                pattern = 0;
            }
        }

        System.out.println(count);
    }
}