import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;
	static int[][] map;
	static int N, M, K, count;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			for(int i = 0; i<N;i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						count++;
						countBug(i, j);
					}
				}
			}
			
			System.out.println(count);
		}
	}

	public static void countBug(int a, int b) {
		q.offer(new int[] {a,b});
		visited[a][b] = true;
		
		while (!q.isEmpty()) {

			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int nr = 0, nc = 0;
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				if (nr >= N || nr < 0 || nc < 0 || nc >= M) {
					continue;
				}
				if (!visited[nr][nc] && map[nr][nc] == 1) { // 진행방향에 배추가 있는경우
					visited[nr][nc] = true; // 방문표시 해주고
					q.offer(new int[] { nr, nc });
				}
			}
			
		}
	}
}