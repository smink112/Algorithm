import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			map.put(i, s);
			map2.put(s, i);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(!Character.isDigit(s.charAt(0))) {	//문자라면
				sb.append(map2.get(s)).append("\n");
			}else if(Character.isDigit(s.charAt(0))) {
				sb.append(map.get(Integer.parseInt(s))).append("\n");
			}
		}
		System.out.println(sb);
	}
}