import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static int[] J, F;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> fireQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        J = new int[2];
        F = new int[2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'J') {
                    J[0] = i;
                    J[1] = j;
                }else if(map[i][j] == 'F'){
                    fireQ.offer(new int[] {i,j, 0});
                }
            }
        }
        int ans = BFS();
        System.out.println(ans==-1? "IMPOSSIBLE" : ans);

    }

    static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {J[0], J[1], 0});
        visited[J[0]][J[1]] = true;

        while (!q.isEmpty()){
            int[] hun = q.poll();

            if(hun[0] == 0 || hun[0] == N-1 || hun[1] == 0 || hun[1] == M-1){
//                System.out.println(hun[0] + " " + hun[1]);
                return hun[2] + 1;
            }
            int[] time = fireQ.peek();
            int temp = 0;
            if(!fireQ.isEmpty() && time[2] == hun[2]) {
                temp = fireQ.size();
            }
            for (int a = 0; a < temp; a++) {
                int[] fire = fireQ.poll();

                for (int i = 0; i < 4; i++) {
                    int fire_nr = fire[0] + dr[i];
                    int fire_nc = fire[1] + dc[i];

                    if (!(fire_nr < 0 || fire_nr >= N || fire_nc < 0 || fire_nc >= M)) {
                        if (map[fire_nr][fire_nc] != '#' && map[fire_nr][fire_nc] != 'F') {
                            map[fire_nr][fire_nc] = 'F';
                            fireQ.offer(new int[]{fire_nr, fire_nc, fire[2] + 1});
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nr = hun[0] + dr[i];
                int nc = hun[1] + dc[i];

                if (!(nr < 0 || nr >= N || nc < 0 || nc >= M)) {
                    if (map[nr][nc] != '#' && map[nr][nc] != 'F' && !visited[nr][nc]) {
                        q.offer(new int[]{nr, nc, hun[2] + 1});
                        visited[nr][nc] = true;
                    }
//                    System.out.println(nr + " " + nc);
                }
            }
//            //map 확인용
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(map[j][k]);
//                }
//                System.out.println();
//            }


        }

        return -1;
    }
}
/*
10 100
....................................................................................................
.......###############.......FFFF..........########.................................................
.........FFFFFFFFFFFFF#############...........................FFF..........##########....########...
.....................................................................######..................####...
.......FF...................................J.......................................................
.............................................................................................####...
......................###############################################...............................
....................................................................................................
.........FFFFFFFFFFFFF............####..........................................FFFFFF....FFFFF.....
.............................................###.######.............................................
 */
//불번지기 -> 내 위치 옮기기 -> 불번지기 -> 내 위치 옮기기