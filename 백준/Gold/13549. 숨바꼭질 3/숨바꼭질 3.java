import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    static int N, K;
    static PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> a[1]-b[1]);
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 내 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        visited = new boolean[100001];
        q.add(new int[] {N, 0}); // 초기 위치를 큐에 넣어준다.

        System.out.println(dijkstra());
    }

    static int dijkstra() { // 우선순위큐를 이용해 구현
        while (!q.isEmpty()) {
            int[] temp = q.poll(); // 초기 index
            visited[temp[0]] = true;

            if(temp[0] == K) {
                return temp[1];
            }

            if(temp[0]*2 <= 100000 && !visited[temp[0]*2]) {
                q.add(new int[] {temp[0]*2, temp[1]});
            }
            if(temp[0]+1 <= 100000 && !visited[temp[0]+1]) {
                q.add(new int[] {temp[0]+1, temp[1]+1});
            }
            if(temp[0]-1 >= 0 && !visited[temp[0]-1]) {
                q.add(new int[] {temp[0]-1, temp[1]+1});
            }
        }

        return -1;
    }
}