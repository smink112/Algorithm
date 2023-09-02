import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, count;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		nQueen(0);

		System.out.println(count);
	}

	static void nQueen(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			boolean flag = true;
			for (int j = 0; j < depth; j++) {
				if (arr[depth] == arr[j]) {
					flag = false;
				}

				else if (Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) {
					flag = false;
				}
			}

			if (flag) {
				nQueen(depth + 1);
			}
		}
	}
}