import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, Min;
	static int[] map;
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[101];
		Min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			map[start] = dest;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			map[start] = dest;
		}

		Game();

		System.out.println(Min);
	}

	static void Game() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 1, 0 }); // 인덱스 값을 계속 줄꺼고, 카운트도 넘겨줘야함
		visited[1] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			if (temp[0] == 100) {
				Min = Math.min(temp[1], Min);
				return;
			}

//			if (map[temp[0]] == 0) {
//				for (int i = 1; i <= 6; i++) {
//					if (temp[0] + i <= 100) {
//						q.offer(new int[] { temp[0] + i, temp[1] + 1 });
//					}
//				}
//			} else {
//				if (!visited[temp[0]])
//					q.offer(new int[] { map[temp[0]], temp[1] }); // 사다리를 타거나 뱀때문에 내려오는건 이동횟수에 포함 안됨
//			}
			for (int i = 1; i <= 6; i++) {
				int nx = temp[0] + i;
				if (100 < nx || visited[nx])
					continue;

				visited[nx] = true;
				if (map[nx] != 0) {
					if (!visited[map[nx]]) {
						q.offer(new int[] { map[nx], temp[1] +1 });
						visited[map[nx]] = true;
					}
				}else {
					q.offer(new int[] {nx,temp[1]+1});
				}
			}
		}
	}
}