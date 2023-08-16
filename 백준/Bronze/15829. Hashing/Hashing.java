import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = new char[N];
	
		arr = br.readLine().toCharArray();
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = ((arr[i]-96) * (int)Math.pow(31, i)) % 1234567891;
			sum = (sum + a) % 1234567891;
		}
		
		System.out.println(sum);
		
	}
}