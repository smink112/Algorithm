import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int Max = 0, N = 0;
		int temp = 0;
		
		for(int i = 1; i <= 9; i++) {
			N = Integer.parseInt(br.readLine());
			if(Max < N){
				Max = N;
				temp = i;
			}
			
		}
		
		System.out.println(Max + "\n" + temp);
	}
}
