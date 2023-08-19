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

	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int[][] map;
	static int N, M, count = 0;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;

		}

		bfs(1);

		System.out.println(count);

	}

	public static void bfs(int v) {
		q.offer(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 1; i <= N; i++) {
				if (map[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}