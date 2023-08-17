import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		
		makeZ(size, r, c);
		
		System.out.println(count);

	}

	public static void makeZ(int size, int r, int c) {
		if (size == 1) {
			return;
		}

		if (r < size / 2 && c < size / 2) { // 1사분면에 있을 때
			makeZ(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) { // 2사분면에 있을 때
			count += size * size / 4;
			makeZ(size / 2, r, c - size / 2);
		} else if (r >= size / 2 && c >= size / 2) { // 3사분면에 있을 때
			count += (size * size / 4) * 3;
			makeZ(size / 2, r - size / 2, c - size / 2);
		} else { // 4사분면에 있을 떄
			count += (size * size / 4) * 2;
			makeZ(size / 2, r - size / 2, c);
		}
	}
}