import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		String[] s = null;
		sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			char[] cArr = br.readLine().toCharArray();
			ArrayList<Integer> arr = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");
			
			boolean reverse = false, temp = false;
			
			while (st.hasMoreElements()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			outer : for (int i = 0; i < cArr.length; i++) {
				switch (cArr[i]) {
				case 'R' :
					reverse = !reverse;
					break;
				case 'D' :
					if(arr.isEmpty()) {
						sb.append("error\n");
						temp = true;
						break outer;
					}else if(reverse) {
						arr.remove(arr.size()-1);
						break;
					}else if(!reverse) {
						arr.remove(0);
						break;
					}
				default:
					break;
				}
			}
			if(reverse) Collections.reverse(arr);
			
			if(!temp)	sb.append(arr.toString().replaceAll(" ", "")).append("\n");
		}
		System.out.print(sb);
	}
}
