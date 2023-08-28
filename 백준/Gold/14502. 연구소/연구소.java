import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, count = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(count);
	}

	public static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] newMap = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
				if (newMap[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (newMap[nr][nc] != 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					newMap[nr][nc] = 2;
					q.offer(new int[] { nr, nc });
				}
			}
		}

		countArea(newMap);
	}

	static void countArea(int[][] newMap) {
		int tempCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) {
					tempCount++;
				}
			}
		}
		count = Math.max(tempCount, count);
	}
}