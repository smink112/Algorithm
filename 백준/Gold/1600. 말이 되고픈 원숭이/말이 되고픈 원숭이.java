import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	static int[][] map;
	static int K, N, M;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우
	static int[][] jump = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };

	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] visited = new boolean[N][M][K + 1];
		q.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int count = temp[2];
			int jcount = temp[3];

			if (r == N - 1 && c == M - 1) {
				return count;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (!visited[nr][nc][jcount] && map[nr][nc] == 0) {
					q.offer(new int[] { nr, nc, count + 1, jcount });
					visited[nr][nc][jcount] = true;
				}
			}

			if (jcount < K) {
				for (int i = 0; i < 8; i++) {
					int nr = r + jump[i][0];
					int nc = c + jump[i][1];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;

					if (!visited[nr][nc][jcount + 1] && map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc, count + 1, jcount + 1 });
						visited[nr][nc][jcount+1] = true;
					}

				}
			}
		}

		return -1;
	}
}