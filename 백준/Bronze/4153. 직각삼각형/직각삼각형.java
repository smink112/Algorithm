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
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		while(A !=0 && B != 0 && C != 0) {
		
			if(A>B && A> C) {
				if(A*A == B*B + C*C) {
					sb.append("right\n");
				}else {
					sb.append("wrong\n");
				}
			}else if(B>A && B > C) {
				if(B*B == A*A + C*C) {
					sb.append("right\n");
				}else {
					sb.append("wrong\n");
				}
			}else if(C>A &&C>B) {
				if(C*C == A*A + B*B) {
					sb.append("right\n");
				}else {
					sb.append("wrong\n");
				}
			}
			
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
	}
}