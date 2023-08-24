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

	static int[][] map;
	static boolean[][] visited;
	static boolean cant;
	static int N, M, Count;
	static int rGram, cGram;

	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 }; // 상, 하, 좌, 우, 우하, 좌하, 우상, 좌상
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}
			Count = 0;
			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						Count++;
						visited[i][j] = true;
						q.offer(new int[] { i, j });
						Find();
					}
				}
			}

			sb.append(Count).append("\n");
		}

		System.out.println(sb);
	}

	public static void Find() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}
}