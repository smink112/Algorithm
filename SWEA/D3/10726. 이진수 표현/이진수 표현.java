import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if (((M >> i )& 1) == 0) {
					flag = false;
				}

			}
			System.out.printf("#%d %s\n", test_case, flag ? "ON" : "OFF");
		}
	}
}