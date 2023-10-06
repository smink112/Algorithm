import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, Min, count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        Min = Integer.MAX_VALUE;

        if (N == K) {
            System.out.printf("%d\n%d", 0, 1);
        } else {
            BFS();
            System.out.printf("%d\n%d", Min, count);
        }

    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        boolean[] visited = new boolean[100001];

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if (temp[0] == K) {
                Min = Math.min(Min, temp[1]);
                if (temp[1] > Min) {
                    break;
                }
                count++;
            }
            if (temp[0] != K)
                visited[temp[0]] = true;

            if (temp[0] - 1 <= 100000 && temp[0] - 1 >= 0 && !visited[temp[0] - 1]) {
                q.offer(new int[]{temp[0] - 1, temp[1] + 1});
            }
            if (temp[0] + 1 <= 100000 && !visited[temp[0] + 1]) {
                q.offer(new int[]{temp[0] + 1, temp[1] + 1});
            }
            if (temp[0] * 2 <= 100000 && !visited[temp[0] * 2]) {
                q.offer(new int[]{temp[0] * 2, temp[1] + 1});
            }
        }

    }

}