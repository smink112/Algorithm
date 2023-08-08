import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int temp = Integer.parseInt(st.nextToken());
		
		if(temp == 1) {
			for (int i = 1; i <= 8; i++) {
				if(temp!=i) {
					System.out.println("mixed");
					break;
				}
				else if(i==8) {
					System.out.println("ascending");
					break;
				}
				temp = Integer.parseInt(st.nextToken());
			}
		}else if(temp == 8) {
			for (int i = 8; i >= 1; i--) {
				if(temp!=i) {
					System.out.println("mixed");
					break;
				}
				else if(i==1) {
					System.out.println("descending");
					break;
				}
				temp = Integer.parseInt(st.nextToken());
			}
		}else {
			System.out.println("mixed");
		}
	}
}
