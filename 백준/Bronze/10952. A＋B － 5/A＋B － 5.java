import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
//		String s = br.readLine();
//		st = new StringTokenizer(s);
//		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if( A == 0 && B == 0) {
				break;
			}else {
				System.out.println(A+B);
			}
		}
		
	}
}
