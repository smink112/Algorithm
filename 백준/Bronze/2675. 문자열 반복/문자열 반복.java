import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			String s = st.nextToken();
			char[] c = s.toCharArray();
			for (int j = 0; j < c.length; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					System.out.print(c[j]);
				}
			}
			System.out.println();
		}
	}
}
