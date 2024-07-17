import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] input = new String[3];
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            input[i] = br.readLine();
        }

        if (isNumber(input[0])) {
            ans = Integer.parseInt(input[0]) + 3;
        } else if (isNumber(input[1])) {
            ans = Integer.parseInt(input[1]) + 2;
        } else if (isNumber(input[2])) {
            ans = Integer.parseInt(input[2]) + 1;
        }

        if (ans % 3 == 0 && ans % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (ans % 3 == 0) {
            System.out.println("Fizz");
        } else if (ans % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(ans);
        }
    }

    private static boolean isNumber(String s) {
        return s.matches("[0-9]*");
    }
}