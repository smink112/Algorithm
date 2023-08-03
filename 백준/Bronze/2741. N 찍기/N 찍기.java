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
//		String s = br.readLine();
//		st = new StringTokenizer(s);

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		
	}
}
