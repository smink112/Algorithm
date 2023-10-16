import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, T, sum;
    static int[][] map;
    static int[][] airCleaner;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        airCleaner = new int[2][2]; // 공기청정기 2종류
        int temp = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airCleaner[temp][0] = i;
                    airCleaner[temp][1] = j;
                    temp++;
                }
            }
        }

        for (int time = 0; time < T; time++){
            spreadDust();
            airCleaning();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0){
                    sum += map[i][j];
                }
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        System.out.println(sum);
    }//main

    private static void spreadDust() {
        int tempMap[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int spreadCnt = 0;
                    int spreadDustSize = map[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr<0 || nc < 0 || nr>=N || nc >= M)
                            continue;

                        if (map[nr][nc] == -1)
                            continue;

                        tempMap[nr][nc] += spreadDustSize;
                        spreadCnt++;
                    }
                    tempMap[i][j] -= spreadCnt * spreadDustSize;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
    }//spreadDust

    public static void airCleaning() {
        //공기청정기 윗부분
        int r = airCleaner[0][0], c = airCleaner[0][1];

        int dir = 0;
        while(true){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr > airCleaner[0][0]){
                dir = 2;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            else if (nr<0) {
                dir = 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            else if (nc>=M) {
                dir = 1;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            if(r == airCleaner[0][0] && c == airCleaner[0][1]){
                r = nr;
                c = nc;
                continue;
            }
            if(map[nr][nc] != -1) {
                map[r][c] = map[nr][nc];
            }
            if (nr == airCleaner[0][0] && nc == airCleaner[0][1]) {
                map[r][c] = 0;
                break;
            }

            r = nr;
            c = nc;
        }


        //공기청정기 아래부분
        int r2 = airCleaner[1][0], c2 = airCleaner[1][1];

        dir = 1;
        while(true){
            int nr = r2 + dr[dir];
            int nc = c2 + dc[dir];

            if(nr >= N){
                dir = 3;
                nr = r2 + dr[dir];
                nc = c2 + dc[dir];
            }
            else if (nc>=M) {
                dir = 0;
                nr = r2 + dr[dir];
                nc = c2 + dc[dir];
            }
            else if (nr<airCleaner[1][0]) {
                dir = 2;
                nr = r2 + dr[dir];
                nc = c2 + dc[dir];
            }

            if(r2 == airCleaner[1][0] && c2 == airCleaner[1][1]){
                r2 = nr;
                c2 = nc;
                continue;
            }
            if(map[nr][nc] != -1)
                map[r2][c2] = map[nr][nc];
            if (nr == airCleaner[1][0] && nc == airCleaner[1][1]) {
                map[r2][c2] = 0;
                break;
            }

            r2 = nr;
            c2 = nc;
        }
    }
}