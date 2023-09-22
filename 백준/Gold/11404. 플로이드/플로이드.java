import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    static int N, M;
    static int[][] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[v].add(new Node(u, cost));
        }

        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            FloydWarshall(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dist[i][j] != Integer.MAX_VALUE ? (dist[i][j] + " ") : (0 + " "));
            }
            System.out.println();
        }
    }//main

    static void FloydWarshall(int start){
        visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (!visited[current.v])
                visited[current.v] = true;
            else
                continue;

            for (int i = 0; i < list[current.v].size(); i++) {
                Node next = list[current.v].get(i);

                if (dist[start][next.v] > dist[start][current.v] + next.cost){
                    dist[start][next.v] = dist[start][current.v] + next.cost;
                    pq.offer(new Node(next.v, dist[start][next.v]));
                }
            }
        }
    }//FloydWarshall

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }//Node
}