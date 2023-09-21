import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    static int N, start, Max;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            list = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (!list[from].contains(to))
                    list[from].add(to);
            }

            visited = new int[101];
            Max = 0;

            call();

            int ans = 0;
            for (int i = 100; i >= 0; i--) {
                if (visited[i] == Max) {
                    ans = i;
                    break;
                }
            }

            System.out.printf("#%d %d\n",test_case,ans);

        }
    }

    static void call() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list[temp].size(); i++) {
                int next = list[temp].get(i);
                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = visited[temp] + 1;
                }
            }

            Max = Math.max(Max, visited[temp]);
        }
    }
}