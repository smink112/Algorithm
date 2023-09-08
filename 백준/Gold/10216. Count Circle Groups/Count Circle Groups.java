import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int[][] arr;
	static int[] parent;
	static int N, group;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N];
			arr = new int[N][3]; // 0 : x, 1 : y, 2 : r
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				parent[i] = i;
			}

			group = N;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (i == j)
						continue;

					int d = (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0])
							+ (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);
					if (d  <= (arr[i][2] + arr[j][2]) * (arr[i][2] + arr[j][2])) {
						// 그럼 이제 얘네 둘을 같은 그룹으로 묶어줘야징
						if (find(i) != find(j)) { // 부모를 찾아서 부모가 다르다면 유니온
							union(i, j);
							group--;
						}
					}
				}
			}

			sb.append(group).append("\n");
		} // test_case
		System.out.println(sb);
	}// main

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}// find

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}// union
}