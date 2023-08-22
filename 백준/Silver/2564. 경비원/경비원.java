import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		int[][] store = new int[K + 1][2];

		int dong = 0, sum = 0;

		int[] storeNum = new int[store.length];
		for (int i = 0; i <= K; i++) { // 마지막 인덱스는 항상 동근이
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());	//동서남북위치
			store[i][1] = Integer.parseInt(st.nextToken());	//동서남북중에서 몇번째에 있는지
		}

		for (int i = 0; i < store.length; i++) {
			switch (store[i][0]) {
			case 1: // 북쪽인경우 그냥 +[i][1]
				storeNum[i] = store[i][1];
				if (i == K) {
					dong = storeNum[i];
				}
				break;
			case 2: // 남쪽인경우 N+M+(N - [i][1])
				storeNum[i] = 2 * N + M - store[i][1];
				if (i == K) {
					dong = storeNum[i];
				}
				break;
			case 3: // 서쪽인 경우 2N+M+(M - [i][1])
				storeNum[i] = 2 * N + 2 * M - store[i][1];
				if (i == K) {
					dong = storeNum[i];
				}
				break;
			case 4: // 동쪽인 경우 N+[i][1]
				storeNum[i] = N + store[i][1];
				if (i == K) {
					dong = storeNum[i];
				}
				break;
			default:
				break;
			}
		}
		
		
		for (int i = 0; i < storeNum.length - 1; i++) {
			int A = storeNum[i];
			if (A > dong) {
				sum += Math.min(Math.abs(Math.abs((2 * N + 2 * M) - A) + dong), Math.abs(A - dong));
			} else {	//동근이가 더 큰경우겠지
				sum += Math.min(Math.abs(Math.abs((2 * N + 2 * M) - dong) + A), Math.abs(dong - A));
			}
			
		}
		System.out.println(sum);
	}
}