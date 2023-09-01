import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int sum, N;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}

		combination(arr, visited, 0, 0, r);

	}

	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
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