import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		prime = new boolean[N + 1];

		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = M; i <= N; i++) {
			if (!prime[i]) {
				System.out.println(i);
			}
		}
	}
}
