import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		int[] len = new int[6];
		int[] dir = new int[6];
		
		int width = 0, height = 0;
		int widthIdx = 0, heightIdx = 0;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			if((dir[i] == 1 || dir[i]== 2 )&& width <len[i]) { //width
				width = len[i];
				widthIdx = i;
				
			}else if((dir[i] == 3 || dir[i] == 4) && height < len[i]) {
				height = len[i];
				heightIdx = i;
			}

		}
		
		int square = (width * height) - (len[(widthIdx+3)%6] * len[(heightIdx+3)%6]);
		
		System.out.println(square * K);
		
	}
}