import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우
	static int[][] map;
	static int N, M;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					q.add(new int[] { i, j }); // 2인 지점의 index를 넣어준다.
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					sb.append(map[i][j]-2).append(" ");
				}else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() { // BFS 메소드 큐를 이용해 구현
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0]; // row값
			int c = temp[1]; // col값
			for (int i = 0; i < 4; i++) { // 4방탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 1) { // 4방향중 하나가 1인경우
					map[nr][nc] = map[r][c] + 1; // map의 값 +1 : 깊이 찾으려고-> 최대값 =거리
					q.add(new int[] { nr, nc }); // 금방 바뀐 자리들의 인덱스 넣어주기.
				}
			}
		}
	}
}