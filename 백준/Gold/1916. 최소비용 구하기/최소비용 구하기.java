import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    static int N, M, start, desti;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[v].add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        desti = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(start);


        System.out.println(dist[desti]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (!visited[current.v])
                visited[current.v] = true;
            else
                continue;

            for (int i = 0; i < list[current.v].size(); i++) {
                Node next = list[current.v].get(i);
                if (dist[next.v] > dist[current.v] + next.cost) {
                    dist[next.v] = dist[current.v] + next.cost;
                    q.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }// dijkstra

    public static class Node implements Comparable<Node> {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }//Node
}