import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static int[][] map;
	static boolean[][] visited;
	static int N, L, R;

	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = false;
		int result = 0;
		
        while (!flag) {
            if (!Move())
                flag = true;
            else
                result++;
        }


//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(result);
	}

	static boolean Move() {	//한번이라도 연합했으면 return true
		visited = new boolean[N][N];
		boolean flag = false;	//한번이라도 연합을 했는지 안했는지 확인해주는 플래그

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int sum = 0;
				if (!visited[r][c]) {
					Queue<int[]> q = new LinkedList<int[]>();
					Queue<int[]> location = new LinkedList<int[]>();
					location.offer(new int[] { r, c });
					q.offer(new int[] { r, c });

					visited[r][c] = true;

					sum = map[r][c];

					while (!q.isEmpty()) {
						int[] temp = q.poll();
						int cr = temp[0];
						int cc = temp[1];

						for (int i = 0; i < 4; i++) {
							int nr = cr + dr[i];
							int nc = cc + dc[i];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;
							if (!visited[nr][nc] && Math.abs(map[nr][nc] - map[cr][cc]) >= L
									&& Math.abs(map[nr][nc] - map[cr][cc]) <= R) {
								q.offer(new int[] { nr, nc });
								location.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
								sum += map[nr][nc];
								flag = true;
							}
						}
					}

					if (flag) {
						int avg = sum / location.size();
						while (!location.isEmpty()) {
							int[] temp = location.poll();
							int cr = temp[0];
							int cc = temp[1];

							map[cr][cc] = avg;
						}
					}
				}
			}
		}
		
		return flag;
	}
}