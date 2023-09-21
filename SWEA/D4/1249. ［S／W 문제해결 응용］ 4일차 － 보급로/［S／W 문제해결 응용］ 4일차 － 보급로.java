import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            visited = new boolean[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            dijkstra();

            System.out.printf("#%d %d\n",test_case, dist[N-1][N-1]);
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        q.offer(new Node(0,0, dist[0][0]));

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (!visited[current.r][current.c])
                visited[current.r][current.c] = true;
            else
                continue;

            for (int i = 0; i < 4; i++) {
                if(current.r + dr[i] < 0 || current.r + dr[i] >= N || current.c + dc[i] < 0 || current.c + dc[i] >=N)
                    continue;

                Node next = new Node(current.r + dr[i], current.c + dc[i], current.cost);

                if (dist[next.r][next.c] > dist[current.r][current.c] + map[current.r][current.c]) {
                    dist[next.r][next.c] = dist[current.r][current.c] + map[current.r][current.c];
                    q.offer(new Node(next.r, next.c, dist[next.r][next.c]));
                }
            }
        }
    }//dijkstra

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int cost;

        Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}