import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int[][] arr;
	static boolean[] selected;
	static int N;
	static int answer;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			selected = new boolean[N];
			answer = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	static int cal() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (selected[i] && selected[j]) {
					a += arr[i][j];
				} else if (!selected[i] && !selected[j]) {
					b += arr[i][j];
				}
			}
		}
		return Math.abs(a - b);
	}

	static void combination(int idx, int cnt) {
		if (cnt == N / 2) {
			answer = Math.min(answer, cal());
			return;
		}

		for (int i = idx; i < N; i++) {
			selected[i] = true;
			combination(i + 1, cnt + 1);
			selected[i] = false;
		}
	}
}