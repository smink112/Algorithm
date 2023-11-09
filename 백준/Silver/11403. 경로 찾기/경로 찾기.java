import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] Nodes;
    static int[][] map, Ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        Ans = new int[N+1][N+1];
        Nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            Nodes[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    Nodes[i].add(j);
                }
            }

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                if(BFS(i,j)) Ans[i][j] = 1;
                else Ans[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(Ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;


        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < Nodes[current].size(); i++) {
                int next = Nodes[current].get(i);

                if(next == y) return true;

                if (visited[next] == false) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}