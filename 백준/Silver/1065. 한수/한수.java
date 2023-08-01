import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int hanCount = 0;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			countHan(i);
		}

		System.out.println(hanCount);
	}

	public static void countHan(int N) {
		if (N < 100) {
			hanCount++;
		} else {
			int[] arr = new int[4];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = N % 10;
				N /= 10;
			}
			int sub = arr[0] - arr[1];
			if (arr[1] - arr[2] == sub && arr[3] != 1) {
				hanCount++;
			}
		}
	}
}
