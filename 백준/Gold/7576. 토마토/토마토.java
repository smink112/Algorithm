import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우
	static Queue<int[]> q = new LinkedList<>();
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 1인경우
					q.add(new int[] { i, j }); // 1의 index를 큐에 넣어준다.
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() { // 너비우선탐색
		while (!q.isEmpty()) { // 큐가 빌때까지
			int[] t = q.poll(); // 1인 index
			int r = t[0]; // row값
			int c = t[1]; // col값
			for (int i = 0; i < 4; i++) { // 4방탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 0) { // 4방향중 하나가 0인경우
					map[nr][nc] = map[r][c] + 1; // map의 값 +1 : 깊이 찾으려고-> 최대값 =걸린 일수
					q.add(new int[] { nr, nc }); // 금방 바뀐 자리들의 인덱스 넣어주기.
				}
			}
		}

		int max = Integer.MIN_VALUE;
		if (isZero()) { // 0이 있는지 없는지 확인
			return -1;
		} else { // 0이 없다면
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) { // 전체 맵을 돌면서 가장 큰 수 찾기 -> 가장 큰 수 : 걸린 일 수
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}

			return max - 1; // 값이 1부터 시작했기 때문에 가장 큰 수 -1 해줘야 걸린 일 수가 됨.
		}

	}

	private static boolean isZero() { // 맵 전체에 0이 있는지 없는지 확인한 후
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) // 0이 있다면 true
					return true;
			}
		}
		return false; // 0이 없다면 false 반환.
	}
}