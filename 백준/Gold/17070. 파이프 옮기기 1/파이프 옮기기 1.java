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
	static int N, count;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		DFS(0, 1, 0);

		System.out.println(count);
	}

	public static void DFS(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			++count;
			return;
		}

		switch (dir) { // 0 : 가로방향, 1 : 세로방향, 2: 대각선방향
		case 0:
			if (c + 1 < N && map[r][c + 1] == 0) { // 우측으로 이동
				DFS(r, c + 1, 0);
			}
			if (r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) { // 대각선방향으로
				// 넘기는방법
				DFS(r + 1, c + 1, 2);
			}
			break;
		case 1:
			if (r + 1 < N && map[r + 1][c] == 0) { // 아래로 이동
				DFS(r + 1, c, 1);
			}
			if (r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) { // 대각선방향으로
				// 넘기는방법
				DFS(r + 1, c + 1, 2);
			}
			break;
		case 2: // 대각선이면 우측, 아래 둘다 이동 가능
			if (c + 1 < N && map[r][c + 1] == 0) { // 가로방향으로 넘기는방법
				DFS(r, c + 1, 0);
			}

			if (r + 1 < N && map[r + 1][c] == 0) { // 세로방향으로 넘기는방법
				DFS(r + 1, c, 1);
			}
			if (r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) { // 대각선방향으로
																												// 넘기는방법
				DFS(r + 1, c + 1, 2);
			}
			break;

		default:
			break;
		}
	}
}