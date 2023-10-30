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
        M = Integer.parseInt(st.nextToken()); // y축
        N = Integer.parseInt(st.nextToken()); // x축
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        start = new int[K][2];
        end = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            start[i][1] = Integer.parseInt(st.nextToken());
            start[i][0] = Integer.parseInt(st.nextToken());
            end[i][1] = Integer.parseInt(st.nextToken());
            end[i][0] = Integer.parseInt(st.nextToken());

            for (int y = start[i][0]; y < end[i][0]; y++) {
                for (int x = start[i][1]; x < end[i][1]; x++) {
                    map[y][x]++;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
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
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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

                if (nr < 0 || nc < 0 || nr >= M || nc >= N || visited[nr][nc])
                    continue;
                if (map[nr][nc] != 0) continue;

                q.offer(new int[]{nr, nc, area++});
                visited[nr][nc] = true;
            }
        }

        list.add(area);
    }
}