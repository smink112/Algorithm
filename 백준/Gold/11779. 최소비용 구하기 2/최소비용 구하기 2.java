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

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] visitCity;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N + 1];
        visitCity = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra();
        System.out.println(dist[end]);

        ArrayList<Integer> route = new ArrayList<>();
        int current = end;
        while(current != 0) {
            route.add(current);
            current = visitCity[current];
        }
        System.out.println(route.size());

        for(int i = route.size() - 1; i >= 0; i--) {
            System.out.print(route.get(i) + " ");
        }

    }//main

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Node(start, 0));
        visitCity[start] = 0;

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
                    visitCity[next.v] =current.v;
                }
            }
        }
    }//dijkstra

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