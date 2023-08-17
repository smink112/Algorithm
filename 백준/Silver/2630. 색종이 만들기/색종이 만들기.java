import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	static int[][] map;
	static int blue = 0; // 1인 색종이
	static int white = 0; // 0인 색종이

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = 0, c = 0;
		makeColorPaper(N, r, c);
		System.out.printf("%d\n%d", white, blue);

	}

	public static void makeColorPaper(int size, int r, int c) {
		if (colorCheck(size, r, c)) {
			if(map[r][c]==1)	blue++;
			else white++;
			return;
		}
			
		int rSize = r + size/2;
		int cSize = c + size/2;
		
		makeColorPaper(size/2, r, c);
		makeColorPaper(size/2, rSize, c);
		makeColorPaper(size/2, r, cSize);
		makeColorPaper(size/2, rSize, cSize);
		
	}
	
	public static boolean colorCheck(int size, int r, int c) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if (map[i][j] != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}