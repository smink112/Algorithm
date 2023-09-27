import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long N;
    static long[][] A = {{1,1},{1,0}};
    static long[][] answer;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        answer = pow(N);

        System.out.println(answer[1][0] % 1000000007);


    }

    public static long[][] pow(long exp) {

        if (exp == 1) { //1제곱이면
            return A;
        }

        long[][] result = pow(exp / 2);

        result = Calc(result, result);

        if (exp % 2 == 1) {
            result = Calc(result, A);
        }

        return result;
    }

    static long[][] Calc(long[][] A1, long[][] A2) {
        long[][] temp = new long[2][2];

        for (int i = 0; i < 2; i++) {   //행렬 곱 식 -> 외우기
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += A1[i][k] * A2[k][j];
                    temp[i][j] %= 1000000007;
                }
            }
        }

        return temp;
    }
}