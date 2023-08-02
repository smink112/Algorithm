import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E, S, M;
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int year = 0;

		while (true) {
			if (year % 15 + 1 == E && year % 28 + 1 == S && year % 19 + 1 == M) {
				System.out.println(++year);
				break;
			} else {
				++year;
			}
		}

	}
}