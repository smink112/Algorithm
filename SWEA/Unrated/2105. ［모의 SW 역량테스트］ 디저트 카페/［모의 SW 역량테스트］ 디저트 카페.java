import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, startR, startC, Max;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 }; // 우하 -> 좌하 -> 좌상 -> 우상
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			Max = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[101];
					startR = i;
					startC = j;
					visited[map[i][j]] = true;
					Route(i, j, 0, 1);
				}
			}

			sb.append("#").append(test_case).append(" ").append(Max).append("\n");
		} // test_case

		System.out.println(sb);
	}// main

	static void Route(int r, int c, int dir, int leng) {
		if (dir >= 4)
			return;

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 방향 그대로 갈 애
			if (nr == startR && nc == startC) {
				Max = Math.max(Max, leng);
				return;
			}
			if (!visited[map[nr][nc]]) {
				visited[map[nr][nc]] = true;
				Route(nr, nc, dir, leng + 1);
				visited[map[nr][nc]] = false;
			}
		}

		if (dir + 1 < 4) { // 방향 바뀌는애
			nr = r + dr[dir + 1];
			nc = c + dc[dir + 1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (nr == startR && nc == startC) {
					Max = Math.max(Max, leng);
					return;
				}
				if (!visited[map[nr][nc]]) {
					visited[map[nr][nc]] = true;
					Route(nr, nc, dir + 1, leng + 1);
					visited[map[nr][nc]] = false;
				}
			}
		}

	}

}