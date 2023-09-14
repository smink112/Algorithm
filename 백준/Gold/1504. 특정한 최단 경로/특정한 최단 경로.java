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

	static int V, E, first, second;
	static int[] dist;
	static ArrayList<Node>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[v].add(new Node(u, d));
			list[u].add(new Node(v, d));
		}
		st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		second = Integer.parseInt(st.nextToken());

		int a = change(first, second);
		int b = change(second, first);
		if (a != Integer.MAX_VALUE || b != Integer.MAX_VALUE) {
			System.out.println(Math.min(a, b));
		}else
			System.out.println(-1);

	}// main

	public static int change(int first, int second) {
		int sum = 0;
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstra(1);

		if (dist[first] == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			sum = dist[first];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);

			dijkstra(first);

			if (dist[second] == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else {
				sum += dist[second];
				Arrays.fill(dist, Integer.MAX_VALUE);
				Arrays.fill(visited, false);

				dijkstra(second);

				return dist[V] == Integer.MAX_VALUE ? dist[V] : sum + dist[V];
			}
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[start] = 0;
		q.offer(new Node(start, 0));

		while (!q.isEmpty()) {
			Node current = q.poll();

			if (!visited[current.v])
				visited[current.v] = true;
			else
				continue;

			for (int i = 0; i < list[current.v].size(); i++) {
				Node next = list[current.v].get(i);
				if (dist[next.v] > dist[current.v] + next.cost) {
					dist[next.v] = dist[current.v] + next.cost;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

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