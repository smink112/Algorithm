import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		char[] arr = s.toCharArray();
		sb = new StringBuilder();
		
		for(int i =97; i <= 122; i++) {
			boolean temp = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					sb.append(j).append(" ");
					temp = true;
					break;
				}
				temp = false;
			}
			if(!temp)	sb.append(-1).append(" ");
		}
		
		System.out.println(sb);
	}
}