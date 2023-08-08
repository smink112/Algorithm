import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine());
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			
			Arrays.sort(arr);
			
			System.out.printf("#%d %d\n", test_case, arr[99]-arr[0]);
			
		}
	}
}
