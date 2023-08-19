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
		int N = Integer.parseInt(br.readLine());
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sortedlist = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			list.add(a);
			sortedlist.add(a);
//			if(!sortedlist.contains(a)) {
//				sortedlist.add(a);
//			}
		}
		
		Collections.sort(sortedlist);
		
		for(int key : sortedlist) {
			if(!map.containsKey(key))	map.put(key, count++);
		}
		
		
		for (int key : list) {
			sb.append(map.get(key)).append(" ");
		}
		
		System.out.println(sb);
		
	}
}