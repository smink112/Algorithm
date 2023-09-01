import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		int[] out = new int[r];
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		permutation(arr, out, visited, 0, r);

	}

	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			for (int i = 0; i < out.length; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}