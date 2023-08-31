import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static int N;
	static long B;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] answer = pow(arr, B);
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				System.out.print(answer[i][j]%1000 + " ");
			}
			System.out.println();
		}
		
	}

	public static int[][] pow(int[][] A, long exp) {

		if (exp == 1) {
			return A;
		}

		int[][] result = pow(A, exp / 2);

		result = Calc(result, result);

		if (exp % 2 == 1) {
			result = Calc(result, arr);
		}

		return result;
	}

	static int[][] Calc(int[][] A1, int[][] A2) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {

					temp[i][j] += A1[i][k] * A2[k][j];
					temp[i][j] %= 1000;
				}
			}
		}
		return temp;
	}
}