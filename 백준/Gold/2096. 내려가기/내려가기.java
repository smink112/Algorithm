import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static int[][] dp_max;
	static int[][] dp_min;
	static int[][] Num;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		dp_max = new int[N][3];
		dp_min = new int[N][3];
		Num = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			Num[i][0] = Integer.parseInt(st.nextToken()); // R
			Num[i][1] = Integer.parseInt(st.nextToken()); // G
			Num[i][2] = Integer.parseInt(st.nextToken()); // B
			dp_max[i][0] = -1;
			dp_max[i][1] = -1;
			dp_max[i][2] = -1;
			dp_min[i][0] = -1;
			dp_min[i][1] = -1;
			dp_min[i][2] = -1;
		}

		dp_max[0][0] = Num[0][0];
		dp_max[0][1] = Num[0][1];
		dp_max[0][2] = Num[0][2];

		dp_min[0][0] = Num[0][0];
		dp_min[0][1] = Num[0][1];
		dp_min[0][2] = Num[0][2];

		int Max_Num = Math.max(DownMax(N - 1, 0), Math.max(DownMax(N - 1, 1), DownMax(N - 1, 2)));
		int Min_Num = Math.min(DownMin(N - 1, 0), Math.min(DownMin(N - 1, 1), DownMin(N - 1, 2)));

		System.out.println(Max_Num + " " + Min_Num);
	}

	public static int DownMax(int N, int idx) {
		if (dp_max[N][idx] == -1) {
			if (idx == 0) {
				dp_max[N][0] = Math.max(DownMax(N - 1, 0), DownMax(N - 1, 1)) + Num[N][0];
			} else if (idx == 1) {
				dp_max[N][1] = Math.max(DownMax(N - 1, 0), Math.max(DownMax(N - 1, 1), DownMax(N - 1, 2))) + Num[N][1];
			} else {
				dp_max[N][2] = Math.max(DownMax(N - 1, 1), DownMax(N - 1, 2)) + Num[N][2];
			}
		}
		return dp_max[N][idx];
	}

	public static int DownMin(int N, int idx) {
		if (dp_min[N][idx] == -1) {
			if (idx == 0) {
				dp_min[N][0] = Math.min(DownMin(N - 1, 0), DownMin(N - 1, 1)) + Num[N][0];
			} else if (idx == 1) {
				dp_min[N][1] = Math.min(DownMin(N - 1, 0), Math.min(DownMin(N - 1, 1), DownMin(N - 1, 2))) + Num[N][1];
			} else {
				dp_min[N][2] = Math.min(DownMin(N - 1, 1), DownMin(N - 1, 2)) + Num[N][2];
			}
		}
		return dp_min[N][idx];
	}
}