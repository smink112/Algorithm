import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		String s= br.readLine();
		
		char[] c = new char[N];
		
		int sum = 0;
		
		for(int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
			sum += c[i] - '0';
		}
		
		System.out.println(sum);
		
		
	}
}
