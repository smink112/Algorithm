import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int sum, N, H;
	static int sub;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람수
			H = Integer.parseInt(st.nextToken()); // 높이
			sub = Integer.MAX_VALUE;
			
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int r = 1; r <= N; r++) {
				sum = 0;
				combination(arr, visited, 0, 0, r);
			}

			System.out.printf("#%d %d\n",test_case, sub);

		}
	}

	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
				if (sum >= H) {
					sub = Math.min(sub, (sum - H));
				}
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}