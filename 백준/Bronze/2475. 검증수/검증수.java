import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		st = new StringTokenizer(s);

//		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[5];
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += (int)Math.pow(arr[i], 2);
		}
		
		int ans = sum%10;
		
		System.out.println(ans);
		
	}
}
