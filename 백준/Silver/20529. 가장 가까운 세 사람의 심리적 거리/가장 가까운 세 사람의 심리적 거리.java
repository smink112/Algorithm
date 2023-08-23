import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;
	static int min;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			min = Integer.MAX_VALUE;

			char[][] arr = new char[N][4];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken().toCharArray();
			}
			

			if(N > 32) {
				sb.append(0).append("\n");
                continue;
            }
			
			
			
			for (int n = 0; n < N; n++) {
				for (int i = n+1; i < N; i++) {
					for (int j = i+1; j < N; j++) {
						int sub = 0;
						for (int k = 0; k < 4; k++) {
							if (arr[n][k] != arr[i][k]) {
								sub++;
							}
							if (arr[n][k] != arr[j][k]) {
								sub++;
							}
							if (arr[i][k] != arr[j][k]) {
								sub++;
							}
						}
						min = Math.min(min, sub);
						if(min == 0)	break;
					}
				}
			}
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}