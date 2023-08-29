import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int[] dr = { -1, 0, 0, 1 }; // 상, 좌, 우, 하
	static int[] dc = { 0, -1, 1, 0 };
	static int N, count = 0;
	static int size = 2, eat = 0; // 아기상어 사이즈, 먹은 먹이 수
	static int[][] map;
	static int[] baby; // 아기상어위치

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		baby = new int[2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					baby[0] = i;
					baby[1] = j;
					map[i][j] = 0;
				}
			}
		}

		EatFish();

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(count);
	}

	static void EatFish() {
		while (true) {
			PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
					: (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));

			boolean[][] visited = new boolean[N][N];
			que.offer(new int[] { baby[0], baby[1], 0 });
			visited[baby[0]][baby[1]] = true;

			boolean flag = false;

			while (!que.isEmpty()) {
				int[] temp = que.poll();
				int r = temp[0];
				int c = temp[1];
				int dist = temp[2];

				if (map[r][c] > 0 && map[r][c] < size) {
					map[r][c] = 0;
					baby[0] = r;
					baby[1] = c;
					eat++;
					count += dist;
					flag = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					if (!visited[nr][nc] && map[nr][nc] <= size) {
						que.offer(new int[] { nr, nc, dist + 1 });
						visited[nr][nc] = true;
					}
				}
			}
			if(!flag)
				break;
			
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
	}
}