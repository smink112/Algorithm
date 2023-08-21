import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		while(K != 0) {
			for (int i = 0; i < arr.length; i++) {
				if(K/arr[N-1-i] != 0) {
					count += K/arr[N-1-i];
					K = K%arr[N-1-i];
					continue;
				}
			}
		}
		System.out.println(count);
	}
}