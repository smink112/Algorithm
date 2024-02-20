import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean check[] = new boolean[31];
        int min = 100, max = 0;
        for (int i = 1; i <= 28; i++) {
            int num = Integer.parseInt(br.readLine());
            check[num] = true;
        }
        for (int i = 1; i <= 30; i++) {
            if (!check[i]){
                if (i < min) min = i;
                if (i > max) max = i;
            }
        }

        System.out.printf("%d\n%d",min,max);

    }
}