import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int N, M;
    static int map[][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int result = countIsland();

            // 빙산 덩어리가 0개(다 녹은 경우)이거나, 2개 이상일 경우 break
            if (result >= 2) {
                break;
            } else if (result == 0) {
                year = 0; // 빙산이 다 녹을 때까지 두 덩어리 이상 분리되지 않는 경우이므로 0을 넣어줌
                break;
            }

            Melt();
            year++;
        }

        System.out.println(year);
    }

    // 빙산 덩어리 개수를 세기
    public static int countIsland() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (!visited[nr][nc] && map[nr][nc] > 0) {
                    dfs(nr, nc, visited);
                }
            }
        }
    }


    static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            IceBerg ice = q.poll();
            // 4방 바다 개수
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nr = ice.row + dr[i];
                int nc = ice.col + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc] && map[nr][nc] == 0) {
                        sea++;
                    }
                }
            }

            if (map[ice.row][ice.col] - sea < 0) {
                // 0보다 작아지면 안됨
                map[ice.row][ice.col] = 0;
            } else {
                map[ice.row][ice.col] -= sea;
            }
        }
    }
}


class IceBerg {
    int row;
    int col;

    public IceBerg(int row, int col) {
        this.row = row;
        this.col = col;
    }
}