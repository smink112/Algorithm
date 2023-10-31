import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K, count = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] start, end;
    static Queue<int[]> q = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }

//        for (int i = M - 1; i >= 0; i--) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(list.size());
        list.sort(null);
        if(!list.isEmpty()) System.out.println(list.get(list.size()-1));
        else System.out.println(0);
    }

    static void BFS(int r, int c) {
        int area = 1;
        q.offer(new int[]{r, c, area});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
                    continue;
                if (map[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc, area++});
                visited[nr][nc] = true;
            }
        }

        list.add(area);
    }
}