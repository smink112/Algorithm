import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		if((N%4 == 0 && N%100 != 0) || N%400 == 0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}