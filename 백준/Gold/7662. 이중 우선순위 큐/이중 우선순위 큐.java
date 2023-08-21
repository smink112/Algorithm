import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			int K = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				String key = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				switch (key) {
				case "I":
					map.put(num, map.getOrDefault(num, 0) + 1);
					break;
				case "D":
					if(map.isEmpty()) break;
					
					int n = num == 1 ? map.lastKey() : map.firstKey();
					int count = map.get(n);
					
					if(count == 1) {
						map.remove(n);
					}else {
						map.put(n, count -1);
					}
					break;
				default:
					break;
				}
			}

			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}