import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, count = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> cheese;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    cheese.add(new int[] {i, j});
                }
            }
        }

        while (cheese.size() != 0){
            visited = new boolean[N][M];
            count++;
            inOutCheck();
            cheeseMelting();
        }

        System.out.println(count);

    }

    public static void inOutCheck(){
    //치즈 공간 내부인지(공기와 접촉하지 않는지) 치즈 공간 외부인지(공기와 접촉하는지) 체크
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        map[0][0] = 2;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc] || map[nr][nc] == 1) continue;

                map[nr][nc] = 2; // 외부 공기 : 2로 바꿔줌
                q.add(new int[] {nr,nc}); // 외부 공기인 경우만 큐에 넣어줌
                visited[nr][nc] = true;
            }
        }
    }

    public static void cheeseMelting(){
        //map[][]의 값이 2이면서, 2면이상 공기에 접촉하면 치즈 녹이기
        for (int i = 0; i < cheese.size(); i++) {
            int[] temp = cheese.get(i);
            int r = temp[0];
            int c = temp[1];

            int airCount = 0;

            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];

                if (map[nr][nc] == 2){
                    airCount++;
                }
            }

            if (airCount>= 2){
                map[r][c] = 0;
                cheese.remove(i);
                i--;
            }
        }
    }
}