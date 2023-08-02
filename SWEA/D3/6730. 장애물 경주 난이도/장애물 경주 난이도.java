import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);

			int[] arr = new int[N];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int up = 0, down = 0;

			for (int i = 0; i < arr.length - 1; i++) {
				up = Math.max(up, arr[i + 1] - arr[i]);
				down = Math.max(down, arr[i] - arr[i + 1]);
			}

			System.out.printf("#%d %d %d\n", test_case, up, down);
		}
	}
}
