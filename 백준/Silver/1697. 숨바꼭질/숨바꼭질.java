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

	static int[] map = new int[100001];
	static int N, K;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 내 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		q.add(N); // 초기 위치를 큐에 넣어준다.

		System.out.println(bfs());
	}

	static int bfs() { // BFS 메소드 큐를 이용해 구현
		while (!q.isEmpty()) {
			int temp = q.poll(); // 초기 index
			if(temp == K) {
				return map[temp];
			}
			if(temp-1 >= 0 && map[temp-1] == 0) {
				map[temp-1] = map[temp] + 1;
				q.add(temp-1);
			}
			if(temp+1 <= 100000 && map[temp+1] == 0) {
				map[temp+1] = map[temp] + 1;
				q.add(temp+1);
			}
			if(temp*2 <= 100000 && map[2*temp] == 0) {
				map[2*temp] = map[temp] + 1;
				q.add(2*temp);
			}
		}

		return -1;
	}
}