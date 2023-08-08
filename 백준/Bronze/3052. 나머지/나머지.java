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
		int count = 0;
		int[] temp = new int[10];
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
			temp[i] = N % 42;
		}
		
		for (int i = 0; i < 42; i++) {
			int tempC = 0;
			for (int j = 0; j < temp.length; j++) {
				if(temp[j] == i) {
					tempC++;
				}
			}
			if(tempC >= 1) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
