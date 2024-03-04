import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Baseball {

        int num, strike, ball;

        public Baseball(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Baseball> inputData = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int possibleCount = 0;

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            Baseball baseball = new Baseball(num, strike, ball);
            inputData.add(baseball);
        }

        for (int i = 123; i <= 987; i++) {
            if (!CheckSame(i)) {    //중복수, 0 확인
                continue;
            }

            int testPass = 0;

            for (int j = 0; j < N; j++) {
                int strikeCount = 0;
                int ballCount = 0;

                String possible = Integer.toString(i);
                String myNum = Integer.toString(inputData.get(j).num);
                // 스트라이크 판별
                for (int k = 0; k < 3; k++) {
                    if (possible.charAt(k) == myNum.charAt(k)) {
                        strikeCount++;
                    }
                }
                // 볼 판별
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (possible.charAt(k) == myNum.charAt(l) && k != l) {
                            ballCount++;
                        }
                    }
                }

                if (strikeCount == inputData.get(j).strike && ballCount == inputData.get(j).ball) {
                    testPass++;
                }
            }
            if (testPass == N) {
                possibleCount++;
            }

        }
        System.out.println(possibleCount);

    }

    static boolean CheckSame(int num) {  //중복수, 0 판별
        String numString = Integer.toString(num);

        if (numString.charAt(0) == numString.charAt(1)) {
            return false;
        }

        if (numString.charAt(1) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == '0' || numString.charAt(1) == '0'
            || numString.charAt(2) == '0') {
            return false;
        }

        return true;
    }
}