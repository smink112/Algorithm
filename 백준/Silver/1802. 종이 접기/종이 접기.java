import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int N;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			arr = br.readLine().split("");
			N = arr.length;

			System.out.println(Fold(0, N - 1) ? "YES" : "NO");
		}
	}

	static boolean Fold(int start, int end) {
		if (start == end) {
			return true;
		}

		int mid = (start + end) / 2;
		for (int i = start; i < mid; i++) {
			if (arr[i].equals(arr[end - i]))
				return false;
		}
		return Fold(start, mid - 1) && Fold(mid + 1, end);
	}
}