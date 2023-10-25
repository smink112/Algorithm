import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] sanggeun, cards;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sanggeun = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(sanggeun);

        M = Integer.parseInt(br.readLine());
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (haveCard(i)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static boolean haveCard(int idx) {
        int leftIndex = 0;
        int rightIndex = N - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;

            if (cards[idx] < sanggeun[midIndex]) rightIndex = midIndex - 1;
            else if (cards[idx] > sanggeun[midIndex]) leftIndex = midIndex + 1;
            else return true;
        }

        return false;
    }
}