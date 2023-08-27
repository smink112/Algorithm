import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		visited = new boolean[101][101];
		int count = 0;
		
		for(int t = 0; t<4;t++) {
			st = new StringTokenizer(br.readLine());
			
			int Ar = Integer.parseInt(st.nextToken());
			int Ac = Integer.parseInt(st.nextToken());
			int Br = Integer.parseInt(st.nextToken());
			int Bc = Integer.parseInt(st.nextToken());
			
			for (int i = Ar; i < Br; i++) {
				for (int j = Ac; j < Bc; j++) {
					if(!visited[i][j]) {
						count++;
						visited[i][j] = true;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}