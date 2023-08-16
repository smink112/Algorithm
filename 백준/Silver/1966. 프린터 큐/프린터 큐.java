import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) { // 테스트 케이스 개수
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 프틴트할 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 출력될 idx

			LinkedList<int[]> q = new LinkedList<int[]>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // 프린트 중요도별로 저~장~
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}

			int count = 0;

			while (!q.isEmpty()) {
				int[] first = q.poll();
				boolean isMax = true;

				for (int i = 0; i < q.size(); i++) {
					if (first[1] < q.get(i)[1]) {
						q.offer(first);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}

						isMax = false;
						break;
					}
				}

				if (!isMax)
					continue;
				count++;

				if (first[0] == M)
					break;
			}
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}
}