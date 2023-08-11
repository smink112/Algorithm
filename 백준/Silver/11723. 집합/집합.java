import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		boolean[] S = new boolean[21];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();

			switch (k) {
			case "add":
				S[Integer.parseInt(st.nextToken())] = true;
				break;
			case "remove":
				S[Integer.parseInt(st.nextToken())] = false;
				break;
			case "check":
				int check = 0;
				check = S[Integer.parseInt(st.nextToken())] ? 1 : 0;
				sb.append(check).append("\n");
				break;
			case "toggle":
				int temp = Integer.parseInt(st.nextToken());
				S[temp] = !S[temp];
				break;
			case "all":
				for (int j = 1; j < S.length; j++) {
					S[j] = true;
				}
				break;
			case "empty":
				for (int j = 1; j < S.length; j++) {
					S[j] = false;
				}
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}
}