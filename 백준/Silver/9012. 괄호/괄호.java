import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			char[] arr;
			arr = br.readLine().toCharArray();
			ArrayList<Integer> list = new ArrayList<Integer>();

			outer : if (arr.length % 2 == 1) {
				sb.append("NO\n");
			}else {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j] == '(') {
						list.add(1);
					}else if(list.isEmpty() != true){
						list.remove(list.size()-1); 
					}else {
						sb.append("NO\n");
						break outer;
					}
					
				}
				if(list.isEmpty())	sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
