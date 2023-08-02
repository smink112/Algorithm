import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int plasticBag5 = 0, plasticBag3 = 0;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(bagCount(N));
		
	}
	
	public static int bagCount(int N) {
		int result = 5000;
		boolean b = false;
		
		for (int i = 0; i * 5 <= N; i++) {
			for (int j = 0; j * 3 <= N; j++) {
				if( i*5 + j*3 == N) {
					result = Math.min(result, i+j);
					b = true;
				}
			}
		}
		if(!b && result == 5000) result = -1;
		return result;
	}
}
