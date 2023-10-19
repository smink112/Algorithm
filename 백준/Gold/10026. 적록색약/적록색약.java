import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, count = 0, count_blind = 0;
    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    BFS(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count_blind++;
                    BFS_blind(i, j);
                }
            }
        }


        System.out.println(count + " " + count_blind);
    }

    public static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        char current = map[r][c];

        while (!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if(nr<0 || nc<0 ||nr>=N||nc>=N || visited[nr][nc]) continue;
                char next = map[nr][nc];
                if(current == next){
                    q.offer(new int[] {nr,nc});
                    visited[nr][nc] = true;
                }
            }

        }
    }

    public static void BFS_blind(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        char current = map[r][c];
        boolean isRorG = false;
        if (current == 'R' || current =='G'){
            isRorG = true;
        }

        while (!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if(nr<0 || nc<0 ||nr>=N||nc>=N || visited[nr][nc]) continue;
                char next = map[nr][nc];
                if(isRorG && (next == 'R' || next == 'G')){
                    q.offer(new int[] {nr,nc});
                    visited[nr][nc] = true;
                }else if(!isRorG && next == current){
                    q.offer(new int[] {nr,nc});
                    visited[nr][nc] = true;
                }
            }

        }
    }
}