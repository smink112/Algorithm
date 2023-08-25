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
	static int N, Max;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우
	
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		
		Max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Max = Math.max(Max, map[i][j]);
			}
		}

		int result = 0;

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int height = 0; height <= Max; height++) {
			result = Math.max(result, DFS(height));
		}
		
		System.out.println(result);
	}

	static int DFS(int height) { // 섬이 다 잠기면 끝
		visited = new boolean[N][N];
		int Count = 0; // 섬 갯수

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c] && map[r][c] > height) {
					q.offer(new int[] {r,c});
					visited[r][c] = true;
					Count++;
					
					while (!q.isEmpty()) {
						int[] temp = q.poll();
						int cr = temp[0];
						int cc = temp[1];

						for (int i = 0; i < 4; i++) {
							int nr = cr + dr[i];
							int nc = cc + dc[i];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;
							if (!visited[nr][nc] && map[nr][nc] > height) {
								q.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		
		
		return Count;
	}
}