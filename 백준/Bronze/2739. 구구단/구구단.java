import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= 9; i++) {
		System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}
}
