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
		
		for(int i = 1; i <= N; i++) {
			int len = (int)Math.log10(i)+1;
			int temp = i;
			
			int sum = temp;
			
			for (int j = 0; j < len; j++) {
				sum += temp%10;
				temp /= 10;
			}
			
			if(sum == N) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}
}