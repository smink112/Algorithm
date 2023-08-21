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
	static char[][] map;
	static int N, M;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					q.offer(new int[] { i, j });
				}
			}
		}
		
		int count = friend();
		
		if (count != 0)
			System.out.println(count);
		else
			System.out.println("TT");
	}

	public static int friend() {
		int count = 0;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
//			visited[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc] != 'X' && !visited[nr][nc]) {
					if (map[nr][nc] == 'P')
						count++;
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}

			}
		}

		return count;
	}
}