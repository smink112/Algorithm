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
	static int N, M;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2]; // 0 : 벽을 안부순 경우의 visited 체크, 1 : 벽을 부순 경우의 visited 체크

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
//				System.out.print(map[i][j] + " ");
			}
//			System.out.println();
		}

		q.add(new int[] { 0, 0, 1, 0 }); // 0,0의 index를 큐에 넣어준다. 0:r 1:c 2:count 3:isDestroyed

		System.out.println(bfs());
	}

	static int bfs() { // BFS 메소드 큐를 이용해 구현
		while (!q.isEmpty()) {
			int[] temp = q.poll(); // 1인 index
			int r = temp[0]; // row값
			int c = temp[1]; // col값
			int count = temp[2]; // count값
			int isDestroyed = temp[3];

			if (r == N - 1 && c == M - 1) {
				return count;
			}

			for (int i = 0; i < 4; i++) { // 4방탐색
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nCnt = count + 1;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 1) { // 진행방향이 벽인경우
					if(isDestroyed == 1)	continue;	//이미 한번 파괴된 경우라면 그냥 지나가
					
					if(visited[nr][nc][1])	continue;	//지나갔던 길이여도 그냥 넘어가
					
					visited[nr][nc][1] = true;	//이젠 한번도 지나간적 없는경우겠지?
					q.offer(new int[] {nr,nc,nCnt,1});
				}else {	//진행 방향이 벽이 아닌경우에는 isDestroyed가 0이겠지
					if(visited[nr][nc][isDestroyed])	continue;	//visited[nr][nc][0] 이 참이라면, -> 안부순 와중에 방문한 경우라면 넘어가
					
					visited[nr][nc][isDestroyed] = true;	//방문한걸로 바꿔주고~
					q.offer(new int[] {nr,nc,nCnt,isDestroyed});
				}
			}
		}
		
		return -1;	//이게 리턴되는거라면 이미 while문 내에서 끝나지 않았다는소리~
	}

}