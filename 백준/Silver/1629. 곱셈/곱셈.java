import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A,B));

	}

	public static int pow(int a, int exp) {

		if (exp == 1) {
			return a%C;
		}

		long result = pow(a, exp / 2);

		result = (result*result)%C;

		if (exp % 2 == 1) {
			result = (result * a)%C;
		}

		return (int)result;
	}
}