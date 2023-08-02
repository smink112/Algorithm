import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		s = br.readLine();
		st = new StringTokenizer(s);
		
		arr[0] = 0;
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] - arr[i] == M) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}
}
