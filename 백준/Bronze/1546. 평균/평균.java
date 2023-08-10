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
		
		double[] arr = new double[N];
		double max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i]/max) * 100;
		}
		
		double avg = sum/N;
		
		System.out.println(avg);
		
	}
}