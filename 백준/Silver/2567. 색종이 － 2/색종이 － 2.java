import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		int K = Integer.parseInt(br.readLine());
		int answer = 0;
		int[][] map = new int[101][101];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(map[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						
						if(nr < 0 || nr>=101 || nc<0 || nc>=101) continue;
						if(map[nr][nc] == 0)	answer++;
					}
				}
			}
		}

		System.out.println(answer);
	}
}