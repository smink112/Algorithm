import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		
		String s = br.readLine();
		
		sb.append(s).append("??!");
		
		System.out.println(sb);
	}

}