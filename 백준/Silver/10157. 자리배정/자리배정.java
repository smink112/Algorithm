import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int N, M, K;
	static int[] dr = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		map = new int[N][M];

		if (K > N * M) {
			sb.append(0).append("\n");
		} else {
			int[] ans = MakeSit();
			sb.append(ans[1]).append(" ").append(ans[0]).append("\n");
		}

		System.out.println(sb);
	}

	static int[] MakeSit() {
		int[] answer = new int[2];
		int num = 1;
		int dir = 0;
		int r = N - 1;
		int c = 0;
		map[r][c] = num++;
		answer[0] = 1;
		answer[1] = 1;
		while (num <= K) {
			r = r + dr[dir];
			c = c + dc[dir];

			if (r >= 0 && r < N && c >= 0 && c < M && map[r][c] == 0) {
				map[r][c] = num++;
				answer[0] = N - r;
				answer[1] = c + 1;
			} else {
				r = r - dr[dir];
				c = c - dc[dir];
				dir = (dir + 1) % 4;
			}

		}

		return answer;
	}
}