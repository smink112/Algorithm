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
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		while (N >= 5) {
			count += N/5;
			N /= 5;
		}
		
		System.out.println(count);

	}
}