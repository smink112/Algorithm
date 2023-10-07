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

    static int N;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[] start = new int[2];
            int[] end = new int[2];
            start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(BFS(start,end));
        }
    }

    static int BFS(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new int[] {start[0],start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];
            int count = temp[2];
            
            if(cr == end[0] && cc == end[1]){
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr< 0 || nr >= N || nc<0 || nc>= N || visited[nr][nc]) continue;

                q.offer(new int[] {nr,nc,count+1});
                visited[nr][nc] = true;
            }
        }

        return 0;
    }
}