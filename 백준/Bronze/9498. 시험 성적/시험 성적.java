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
		
		if(N >= 90 && N<=100) {
			System.out.println("A");
		}else if(N >= 80 && N<90) {
			System.out.println("B");
		}else if(N >= 70 && N<80) {
			System.out.println("C");
		}else if(N >= 60 && N<70) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}

	}
}