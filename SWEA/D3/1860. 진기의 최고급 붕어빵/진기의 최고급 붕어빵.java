import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static Queue<int[]> q = new LinkedList<>();
	static boolean[] visited;
	static int[][] map;
	static int N, M, count = 0;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		outer : for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//사람수
			int M = Integer.parseInt(st.nextToken());	//몇초 걸리는지
			int K = Integer.parseInt(st.nextToken());	//몇개 만드는지
			
			int bbang = 0;
			boolean flag = true;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list);
			
			for (int i = 0; i < list.size(); i++) {
				bbang = (list.get(i) / M) * K - i;
				if(bbang <= 0) {
					sb.append("#").append(test_case).append(" Impossible\n");
					flag = false;
					continue outer;
				}
			}
			if(flag) {
				sb.append("#").append(test_case).append(" Possible\n");
			}
		}
		System.out.println(sb);
	}
}