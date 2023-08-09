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
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int a=0,b=0;
			
			if(N%H == 0) {
				a = H*100;
				b = N/H;
			}else {
				a = N%H * 100;
				b = N/H+1;
			}
			
			sb.append(a+b).append("\n");
		}
		System.out.println(sb);
	}
}