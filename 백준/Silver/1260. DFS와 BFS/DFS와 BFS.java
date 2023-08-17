import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	static boolean node[][]; // 인접행렬 배열
	static boolean visited[]; // 노드의 방문여부 표시 배열
	static Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐
	static int[][] map;
	static int N, M, V;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		node = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) { // 인접행렬로 그래프를 구현
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = true;
			node[b][a] = true;
		}
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(sb);
	}

	private static void dfs(int x) { // DFS 메소드 재귀호출 반복
		if (visited[x])
			return; // 방문 노드일시 종료

		visited[x] = true; // 방문시 방문 확인
		sb.append(x).append(" ");
		for (int i = 1; i < node.length; i++) { // 인접행렬의 경우 행열이 대각선을 기준으로 대칭이 되므로 행 또는 열을 기준으로만 탐색하면된다.
			if (node[x][i]) { // 방문하지 않은 노드의 인접 노드일 경우

				dfs(i); // 해당 노드로 이동
			}
		}
	}
	
	static void bfs(int x) { //BFS 메소드 큐를 이용해 구현
	      
		queue.offer(x); // 큐에 시작 노드 삽입
		visited[x] = true; // 시작 노드를 방문 표시
		while(!queue.isEmpty()) { // 공백큐가 될 때까지 반복
			x = queue.poll(); // 큐에서 하나 꺼낸다.
			sb.append(x).append(" ");
			for(int i =1;i<node.length;i++) { // 큐에서 꺼낸 노드와 연결된 노드를 탐색			
				if(!visited[i] && node[x][i] ) {	// 큐에서 꺼낸 노드와 연결된 노드가 방문하지 않았던 노드라면
					queue.offer(i); // 큐에 삽입 후
					visited[i] = true; // 방문 표시
				}
			}
		}
	}
}