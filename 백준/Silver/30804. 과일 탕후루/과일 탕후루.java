import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] arr;
    public static int[] countFruit;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        countFruit = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol(0, 0, 0, 0, 0));
    }

    private static int sol(int left, int right, int count, int kind, int max) {
        if (right >= N) {
            return max;
        }

        if (countFruit[arr[right]] == 0) {
            kind++;
        }

        countFruit[arr[right]]++;
        count++;

        if (kind > 2) {
            countFruit[arr[left]]--;
            count--;
            if (countFruit[arr[left]] == 0) {
                kind--;
            }
            left++;
        }
        max = Math.max(count, max);

        return sol(left, right + 1, count, kind, max);
    }
}