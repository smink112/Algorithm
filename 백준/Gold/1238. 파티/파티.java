import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int N, M, X, max;
	static int[] go, back;
	static ArrayList<Node>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[v].add(new Node(u, d));
		}

		go = new int[N + 1];
		back = new int[N + 1];
		visited = new boolean[N + 1];

		back = dijkstra(X);
		for (int i = 1; i <= N; i++) {
			go = dijkstra(i);
			
			max = Math.max(max, go[X] + back[i]);
		}

		System.out.println(max);

	}// main

	public static int[] dijkstra(int start) {
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		PriorityQueue<Node> q = new PriorityQueue<>();
		dp[start] = 0;
		q.offer(new Node(start, 0));

		while (!q.isEmpty()) {
			Node current = q.poll();

			if (!visited[current.v])
				visited[current.v] = true;
			else
				continue;

			for (int i = 0; i < list[current.v].size(); i++) {
				Node next = list[current.v].get(i);
				if (dp[next.v] > dp[current.v] + next.cost) {
					dp[next.v] = dp[current.v] + next.cost;
					q.offer(new Node(next.v, dp[next.v]));
				}
			}
		}
		return dp;
	}// dijkstra

	public static class Node implements Comparable<Node> {
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}// Node
}