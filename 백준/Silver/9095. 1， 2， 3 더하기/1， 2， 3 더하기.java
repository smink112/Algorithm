import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	static Integer[] dp = new Integer[12];
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		
		
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(addAll(N)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int addAll(int N) {
		if(dp[N] == null) {
			dp[N] = addAll(N-3) + addAll(N-2) +addAll(N-1); 
		}
		
		return dp[N];
	}
}