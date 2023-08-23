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
	static int N, M, count = 1, dir = 0;

	static int[] dr = { -1, 0, 1, 0 }; // 북, 서, 남, 동
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		dir = (4-Integer.parseInt(st.nextToken()))%4;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.offer(new int[] { row, col });

		cleaning();
		System.out.println(count);
	}

	public static void cleaning() {
		while (!q.isEmpty()) {
			boolean flag = false;
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int nr = 0;
			int nc = 0;
			visited[r][c] = true;
			map[r][c] = -1;
			for (int i = 0; i < 4; i++) {
				dir = (dir + 1)%4;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (!visited[nr][nc] && map[nr][nc] != 1) {
					flag = true;
					break;
				}
			}
			if(flag && map[nr][nc]== 0) {
				q.offer(new int[] {nr, nc});
				count++;
			}
			else if (!flag) {
				nr = r - dr[dir];
				nc = c - dc[dir];
				if (map[nr][nc] != 1) {
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}