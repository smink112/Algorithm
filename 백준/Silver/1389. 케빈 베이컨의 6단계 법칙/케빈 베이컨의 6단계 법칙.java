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
	static boolean[] visited;
	static int[][] map;
	static int N, M, count = 0;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;

		}

		int min = Integer.MAX_VALUE;
		int V = 0;
		for (int i = 1; i <= N; i++) {
			if (bfs(i) < min) {
				min = bfs(i);
				V = i;
			}
		}

		System.out.println(V);
	}

	public static int bfs(int v) {
		visited = new boolean[N + 1];
		q.offer(new int[] { v, 0 });
		visited[v] = true;
		int count = 0;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int num = temp[0];
			int value = temp[1];
			count += value;
			for (int i = 1; i <= N; i++) {
				if (map[num][i] == 1 && !visited[i]) {
					q.offer(new int[] { i, value + 1 });
					visited[i] = true;
				}
			}
		}
		return count;
	}
}