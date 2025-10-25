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
    static int N, M, start, end;

    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<BusStop> pq = new PriorityQueue<>();
    static ArrayList<BusStop>[] list;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[v].add(new BusStop(u, d));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        pq.add(new BusStop(start, 0));
        distance[start] = 0;
        
        while (!pq.isEmpty()) {
            BusStop nowNode = pq.poll();
            int now = nowNode.nextStop;

            if (visited[now]) continue;
            visited[now] = true;

            for (BusStop stop : list[now]) {
                if (!visited[stop.nextStop] && distance[stop.nextStop] > distance[now] + stop.value) {
                    distance[stop.nextStop] = distance[now] + stop.value;
                    pq.add(new BusStop(stop.nextStop, distance[stop.nextStop]));
                }
            }
        }

        System.out.println(distance[end]);
    }

}

class BusStop implements Comparable<BusStop> {
    int nextStop, value;

    BusStop(int vertex, int value) {
        this.nextStop = vertex;
        this.value = value;
    }

    public int compareTo(BusStop o) {
        if (this.value > o.value) return 1;
        else return -1;
    }
}