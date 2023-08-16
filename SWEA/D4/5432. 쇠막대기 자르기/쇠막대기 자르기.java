import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {

			char[] arr = br.readLine().toCharArray();

			int count = 0;
			int pipe = 1;
			for (int i = 1; i < arr.length; i++) {
				if(arr[i] == '(') {
					pipe++;
				}
				else if(arr[i] == ')' && arr[i-1] == '(') {
					pipe--;
					count += pipe;
				}
				else if(arr[i] ==')' && arr[i-1] == ')') {
					count += 1;
					pipe--;
				}
			}

			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}