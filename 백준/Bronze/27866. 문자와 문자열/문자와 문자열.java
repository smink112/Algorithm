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
		char[] c = s.toCharArray();
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(c[N-1]);
		
		
	}
}