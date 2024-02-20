import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        num1 = ((num1%10) * 100) + ((num1%100)/10 * 10) + (num1/100);
        num2 = ((num2%10) * 100) + ((num2%100)/10 * 10) + (num2/100);

        if(num1 > num2) System.out.println(num1);
        else System.out.println(num2);
    }
}