import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int N;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		for (int i = 0; i < N; i++)
			tree.add(new ArrayList<>());

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}

		boolean[] visited = new boolean[N];
		int[] parentNode = new int[N];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int v = q.remove();
			for (int node : tree.get(v))
				if (!visited[node]) {
					visited[node] = true;
					q.offer(node);
					parentNode[node] = v+1;
				}
		}
		
		for (int i = 1; i < parentNode.length; i++) {
			sb.append(parentNode[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}