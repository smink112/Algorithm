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
		ArrayList<Integer> arr = new ArrayList<Integer>();
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				arr.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if( arr.isEmpty() != true) {
					sb.append(arr.get(arr.size()-1) + "\n");
					arr.remove(arr.size()-1);
				}else {
					sb.append(-1 + "\n");
				}
				break;
			case "size":
				sb.append(arr.size() + "\n");
				break;
			case "empty":
				sb.append((arr.isEmpty() == true ? 1 : 0 )+ "\n");
				break;
			case "top":
				sb.append((arr.isEmpty() != true ? arr.get(arr.size() - 1) : -1) + "\n");
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}
}
