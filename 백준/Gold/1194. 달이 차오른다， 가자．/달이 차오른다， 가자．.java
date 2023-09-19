import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, currentR, currentC;
    ;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    currentR = i;
                    currentC = j;
                }
            }
        }

        System.out.println(bfs());

    }


    static int bfs() {
        visited = new boolean[N][M][64];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{currentR, currentC, 0, 0});
        visited[currentR][currentC][0] = true;

        while (!q.isEmpty()) {
            int temp[] = q.poll();
            int r = temp[0];
            int c = temp[1];
            int count = temp[2];
            int keys = temp[3];
            if (map[r][c] == '1') {
                return count;
            }


            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (visited[nr][nc][keys] || map[nr][nc] == '#') continue;

                int newkey = 0;
                switch (map[nr][nc]) {
                    case 'a':  //키
                        if ((keys & 1) != 1) {
                            newkey = 63 & (keys + 1);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'b':
                        if ((keys >> 1 & 1) != 1) {
                            newkey = 63 & (keys + 2);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'c':
                        if ((keys >> 2 & 1) != 1) {
                            newkey = 63 & (keys + 4);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'd':
                        if ((keys >> 3 & 1) != 1) {
                            newkey = 63 & (keys + 8);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'e':
                        if ((keys >> 4 & 1) != 1) {
                            newkey = 63 & (keys + 16);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'f':
                        if ((keys >> 5 & 1) != 1) {
                            newkey = 63 & (keys + 32);
                            q.offer(new int[]{nr, nc, count + 1, newkey});
                            visited[nr][nc][newkey] = true;
                        } else {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'A':  //문
                        if ((keys & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'B':
                        if ((keys >> 1 & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'C':
                        if ((keys >> 2 & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'D':
                        if ((keys >> 3 & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'E':
                        if ((keys >> 4 & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    case 'F':
                        if ((keys >> 5 & 1) == 1) {
                            q.offer(new int[]{nr, nc, count + 1, keys});
                            visited[nr][nc][keys] = true;
                        }
                        break;
                    default:
                        q.offer(new int[]{nr, nc, count + 1, keys});
                        visited[nr][nc][keys] = true;
                        break;

                }
            }

        }

        return -1;
    }
}