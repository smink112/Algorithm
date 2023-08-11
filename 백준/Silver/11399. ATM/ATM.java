import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		int[] arr = new int[N + 1];
		arr[0] = 0;
		int arrsum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i];
			arrsum += arr[i];
		}
		
		System.out.println(arrsum);

	}
}