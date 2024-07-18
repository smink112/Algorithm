import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M, ans = Integer.MIN_VALUE;
    public static int[][] map;
    public static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curRow = row + dr[i];
            int curCol = col + dc[i];

            if (curRow < 0 || curRow >= N || curCol < 0 || curCol >= M) continue;

            if (!visit[curRow][curCol]) {
                if (count == 2) {
                    visit[curRow][curCol] = true;
                    dfs(row, col, sum + map[curRow][curCol], count + 1);
                    visit[curRow][curCol] = false;
                }

                visit[curRow][curCol] = true;
                dfs(curRow, curCol, sum + map[curRow][curCol], count + 1);
                visit[curRow][curCol] = false;
            }
        }
    }
}