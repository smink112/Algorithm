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

    static int N, M, R;    //N : 지역의 개수, M : 수색 범위, R : 길의 개수
    static int[] Max;   // Max : 얻을 수 있는 최대 아이템의 수
    static int[] item;  //각 구역에 있는 아이템의 개수
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Max = new int[N+1];
        item = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dijkstra(i);

            for (int j = 1; j <= N; j++) {
                if(dist[j] <= M){
                    Max[i] += item[j];
//                    System.out.println("item : " + item[j]+ " dist : "+ dist[j]);
                }
            }
//            System.out.println("max["+i+"] : " + Max[i]);
        }

        Arrays.sort(Max);

        System.out.println(Max[N]);
    }// main

    public static void dijkstra(int start){
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
    }// Node
}