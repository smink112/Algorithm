import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int[] dr = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dc = { 0, 0, -1, 1 }; // 상,하,좌,우
	static int[][] map;
	static int N,M;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		q.add(new int[] { 0, 0 }); // 0,0의 index를 큐에 넣어준다.
		
		System.out.println(bfs());
	}
	
	static int bfs() { //BFS 메소드 큐를 이용해 구현
	    while(!q.isEmpty()) {
	    	int[] temp = q.poll(); // 1인 index
			int r = temp[0]; // row값
			int c = temp[1]; // col값
			for (int i = 0; i < 4; i++) { // 4방탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 1) { // 4방향중 하나가 0인경우
					map[nr][nc] = map[r][c] + 1; // map의 값 +1 : 깊이 찾으려고-> 최대값 =걸린 일수
					q.add(new int[] { nr, nc }); // 금방 바뀐 자리들의 인덱스 넣어주기.
				}
			}
	    }
	    
	    return map[N-1][M-1];
	}
}