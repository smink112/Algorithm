import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		int count = 0;
		int maxH = Integer.MIN_VALUE;
		int maxL = Integer.MIN_VALUE;
		int minL = Integer.MAX_VALUE;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, height);
			maxL = Math.max(maxL, L);
			minL = Math.min(minL, L);
			arr[i][0] = L;
			arr[i][1] = height;
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

		for (int i = 0; i < N;) {
			int j = i + 1;
			int maxIdx = j;
			while (j < N && arr[i][1] > arr[j][1]) {
				if (arr[maxIdx][1] < arr[j++][1])
					maxIdx = j - 1;
			}

			if (j >= N) {
				count += arr[i][1];
				if (maxIdx < N)
					count += arr[maxIdx][1] * (arr[maxIdx][0] - arr[i][0] - 1);
				i = maxIdx;
			} else {
				count += arr[i][1] * (arr[j][0] - arr[i][0]);
				i = j;
			}

		}

		System.out.println(count);
	}
}