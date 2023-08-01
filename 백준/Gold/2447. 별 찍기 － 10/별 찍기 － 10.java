import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = '*';
			}
		}

		arr = makeStar(N, N, arr);

		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static char[][] makeStar(int N, int idx, char[][] arr) {
		char[][] result = new char[N][N];
		result = arr;
		if (idx != 1) {
			for (int i = 0; i < N; i += idx) {
				for (int j = i + idx/3; j < i + idx/3 * 2; j++) {
					for (int i2 = 0; i2 < N; i2+= idx) {
						for (int k = i2 + idx/3; k < i2 + idx/3 * 2; k++) {
							result[j][k] = ' ';
						}
					}
					
				}
			}
			return makeStar(N, idx / 3, result);
		} else {
			return result;
		}
	}
}
