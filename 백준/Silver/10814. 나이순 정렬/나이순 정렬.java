import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		String[][] person = new String[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = st.nextToken();
			person[i][1] = st.nextToken();
		}
	
		Arrays.sort(person, new Comparator<String[]>() {
			// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});
 
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(person[i][0]).append(' ').append(person[i][1]).append('\n');
		}
        
		System.out.println(sb);
	}
}