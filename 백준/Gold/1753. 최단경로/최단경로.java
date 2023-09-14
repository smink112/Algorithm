import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int V, E, K;
	static int[] dist;
	static ArrayList<Node>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

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
		}

		visited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstra();

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb);

	}// main

	public static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[K] = 0;
		q.offer(new Node(K, 0));

		while (!q.isEmpty()) {
			Node current = q.poll();

			if (!visited[current.v])
				visited[current.v] = true;
			else
				continue;

			for (int i = 0; i < list[current.v].size(); i++) {
				Node next = list[current.v].get(i); // 갈 수 있는 다음 노드는 현재 노드 리스트에 저장된 애들
				// 다음 노드까지 가는데 걸리는 최소 거리가 저장된 거리가 현재 노드에 저장되어있는 거리 + 현재노드에서 다음노드까지 걸리는 거리보다 크다면
				if (dist[next.v] > dist[current.v] + next.cost) {
					// 다음 노드까지 가는 최소거리를 현재 노드에 저장되어있는 거리 + 현재노드에서 다음노드까지 걸리는 거리로 바꿔줌
					dist[next.v] = dist[current.v] + next.cost;
					// 다음 노드 번호와 다음 노드의 거리를 넘겨줌 -> 다음 사이클에서 현재 노드번호가 되기 위해
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
		public int compareTo(Node n) {
            return this.cost - n.cost;
        }
	}// node
}