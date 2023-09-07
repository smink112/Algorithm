import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, Max = Integer.MIN_VALUE, lastNode;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	

	public static void main(String[] args) throws IOException {
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while (st.hasMoreElements()) {
				int nextV = Integer.parseInt(st.nextToken());
				if (nextV != -1) {
					int dist = Integer.parseInt(st.nextToken());
					list[v].add(new Node(nextV, dist));
				}
			}
		}
		visited = new boolean[V + 1];
		DFS(1,0);
		visited = new boolean[V + 1];
		DFS(lastNode,0);
		
		System.out.println(Max);
	}
	
	public static void DFS(int v, int dist) {
		 if(dist > Max) {
	            Max = dist;
	            lastNode = v;
	        }
	        visited[v] = true;
	        
	        for(int i = 0; i < list[v].size(); i++) {
	            Node node = list[v].get(i);
	            if(visited[node.v] == false) {
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