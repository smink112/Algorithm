import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, W;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int test_case = 1; test_case <= TC; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //지점의 수
            M = Integer.parseInt(st.nextToken());   //도로의 개수
            W = Integer.parseInt(st.nextToken());   //웜홀의 개수

            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                list[S].add(new Node(E, T));
                list[E].add(new Node(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                list[S].add(new Node(E, -T));
            }

            boolean flag = false;
            for (int i = 1; i <= N; i++) {
                dist = new int[N + 1];
                visited = new boolean[N + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);

                if (BellmanFord(i)){
                    sb.append("YES\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }//main

    static boolean BellmanFord(int start) {
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        dist[start] = 0;
//        pq.offer(new Node(start, 0));
//
//        while (!pq.isEmpty()) {
//            Node current = pq.poll();
//            if (!visited[current.v])
//                visited[current.v] = true;
//            else
//                continue;
//
//            for (int i = 0; i < list[current.v].size(); i++) {
//                Node next = list[current.v].get(i);
//
//                if (dist[next.v] > dist[current.v] + next.cost) {
//                    dist[next.v] = dist[current.v] + next.cost;
//                    pq.offer(new Node(next.v, dist[next.v]));
//                }
//            }
//        }
        dist[start] = 0;

        for (int i = 0;i < N - 1; i++) {
            boolean isChange = false;

            for (int j = 1; j <= N; j++) {
                for (Node node : list[j]) {
                    if (dist[j] != Integer.MAX_VALUE && dist[node.v] > dist[j] + node.cost) {
                        dist[node.v] = dist[j] + node.cost;
                        isChange = true;
                    }
                }
            }

            if (!isChange) break;
        }

        for (int j = 1; j <= N; j++) {
            for (Node node : list[j]) {
                if (dist[j] != Integer.MAX_VALUE && dist[node.v] > dist[j] + node.cost) {
                    return true;
                }
            }
        }

        return false;

    }//BellmanFord

    static class Node implements Comparable<Node> {
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