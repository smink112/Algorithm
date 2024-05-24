import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static long[] trees;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];
        trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(trees);

        binarySearch(trees[N - 1], trees);
        System.out.println(ans);
    }

    private static void binarySearch(long top, long[] arr) {
        long bottom = 1;
        while (bottom <= top) {
            long mid = (bottom + top) / 2;
            long sum = 0;

            for (long tree : arr) {
                if (tree > mid) {
                    if (sum > M) {
                        break;
                    }
                    sum += tree - mid;
                }

            }

            if (sum >= M) {
                ans = max(mid, ans);
                bottom = mid + 1;
            } else {
                top = mid - 1;
            }

        }
    }

}