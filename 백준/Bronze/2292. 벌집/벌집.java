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
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int a = 1;
		int r = 1;
		int num = a;
		while (true) {
			if (num >= N) {
				System.out.println(r);
				break;
			}
			num += r*6;
			r++;
		}
	}
}