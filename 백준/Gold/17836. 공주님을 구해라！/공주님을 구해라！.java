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
	static boolean[][][] visited;
	static boolean cant;
	static int N, M, T, Min;
	static int rGram, cGram;

	static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> q1 = new LinkedList<int[]>();
	static Queue<int[]> q2 = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];
		Min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					rGram = i;
					cGram = j;
				}
			}
		}

		q1.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		int gramTime = Gram();

		q2.offer(new int[] { 0, 0, 0 });
		visited[0][0][1] = true;
		int noGramTime = NoGram();

		if (gramTime != -1 && noGramTime != -1) {
			Min = Math.min(gramTime, noGramTime);
			System.out.println(Min);
		} else if (gramTime == -1 && noGramTime == -1) {
			System.out.println("Fail");
		} else if (gramTime != -1 && noGramTime == -1) {
			System.out.println(gramTime);
		} else if (gramTime == -1 && noGramTime != -1) {
			System.out.println(noGramTime);
		}
	}

	public static int Gram() {
		boolean get = false;
		int time = 0;
		while (!q1.isEmpty()) {
			int[] temp = q1.poll();
			int r = temp[0];
			int c = temp[1];
			time = temp[2];
			if (time > T) {
				return -1;
			}
			if (r == rGram && c == cGram) {
				get = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int ntime = time + 1;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if ((map[nr][nc] == 0 || map[nr][nc] == 2) && !visited[nr][nc][0]) {
					q1.offer(new int[] { nr, nc, ntime });
					visited[nr][nc][0] = true;
				}
			}
		}
		
		if (get) {
			q1.clear();
			q1.offer(new int[] { rGram, cGram, time });
			visited = new boolean[N][M][2];
		}

		while (!q1.isEmpty()) {
			int[] temp = q1.poll();
			int r = temp[0];
			int c = temp[1];
			time = temp[2];
			if (time > T) {
				return -1;
			}
			if (r == N - 1 && c == M - 1) {
				return time;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int ntime = time + 1;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (!visited[nr][nc][0]) {
					q1.offer(new int[] { nr, nc, ntime });
					visited[nr][nc][0] = true;
				}
			}
		}
		return -1;
	}

	public static int NoGram() {
		while (!q2.isEmpty()) {
			int[] temp = q2.poll();
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			if (time > T) {
				return -1;
			}
			if (r == N - 1 && c == M - 1) {
				return time;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int ntime = time + 1;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc] == 0 && !visited[nr][nc][1]) {
					q2.offer(new int[] { nr, nc, ntime });
					visited[nr][nc][1] = true;
				}
			}
		}
		return -1;
	}
}