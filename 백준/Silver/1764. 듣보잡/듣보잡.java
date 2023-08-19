import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				list.add(s);
				count++;
			}
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(count);
		System.out.println(sb);

	}
}