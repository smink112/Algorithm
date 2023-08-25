import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람수
			int M = Integer.parseInt(st.nextToken()); // 몇초 걸리는지

			char[][] map = new char[N][M];

			int[] W = new int[N]; // 각 행에서의 색상 개수
			int[] B = new int[N];
			int[] R = new int[N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W') {
						W[i]++;
					} else if (map[i][j] == 'B') {
						B[i]++;
					} else {
						R[i]++;
					}
				}
			}

			int count = 0;

			for (int i = 1; i <= N - 2; i++) {
				for (int j = i; j <= N - 1; j++) {
					int wCnt = 0;
					int bCnt = 0;
					int rCnt = 0;

					for (int k = 0; k < i; k++) {
						wCnt += W[k]; // W가 나올 수 있는 행에서 W의 개수
					}
					for (int k = i; k < j; k++) {
						bCnt += B[k]; // B가 나올 수 있는 행에서 B의 개수
					}
					for (int k = j; k < N; k++) {
						rCnt += R[k]; // R가 나올 수 있는 행에서 R의 개수
					}

					count = Math.max(count, wCnt + bCnt + rCnt); // count는 변하지 않아도 되는 색깔의 갯수
				}
			}

			int ans = N * M - count;

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}