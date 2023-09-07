import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, Max = Integer.MIN_VALUE, lastNode;
	static ArrayList<Node>[] list;
	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int nextV = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[v].add(new Node(nextV, dist));
			list[nextV].add(new Node(v, dist));
		}
		visited = new boolean[N + 1];

		DFS(1, 0);
		visited = new boolean[N + 1];
		DFS(lastNode, 0); // 이게 왜 꼭 필요한것인가..?

		System.out.println(Max);
	}

	public static void DFS(int v, int dist) {
		if (dist > Max) {
			Max = dist;
			lastNode = v;
		}
		visited[v] = true;

		for (int i = 0; i < list[v].size(); i++) {
			Node node = list[v].get(i);
			if (visited[node.v] == false) {
				DFS(node.v, node.dist + dist);
				visited[node.v] = true;
			}
		}
	}

	public static class Node {
		int v;
		int dist;

		public Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
	}
}