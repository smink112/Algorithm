import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int M, N;
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		System.out.println(greatestDivisor(M, N));
		System.out.println(M*N / greatestDivisor(M, N));
	}

	public static int greatestDivisor(int a, int b) {
		if( b == 0) {
			return a;
		}
		return greatestDivisor(b, a % b);
	}
	
	
}