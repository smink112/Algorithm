import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int sum = 0, start = 0, end = 0;
		int res = Integer.MAX_VALUE;

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			if (sum >= S) {
				sum -= arr[start];
				res = Math.min(res, end-start);
				start++;
			}else if(end == N){
				break;
			}else {
				sum += arr[end++];
			}
		}
		
		System.out.println(res!=Integer.MAX_VALUE ? res : 0);
	}
}
