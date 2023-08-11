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

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<Integer>();
		double sum = 0;

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}

		Collections.sort(list);

		// 산술평균 출력
		sb.append(Math.round(sum / list.size())).append("\n");

		// 중앙값 출력
		sb.append(list.get(list.size() / 2)).append("\n");

		// 최빈값 출력(최빈값이 여러개라면 최빈값중 두번째로 작은값 출력)
		int[][] count = new int[N][2]; // 0 : index, 1 : count
		count[0][0] = list.get(0);
		count[0][1] = 1;
		int max = 1;
		int temp = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i < list.size(); i++) {
			count[i][0] = list.get(i);
			if (count[i - 1][0] == count[i][0]) {
				count[i][1] = count[i - 1][1] + 1;
			}else {
				count[i][1] = 1;
			}
			max = Math.max(max, count[i][1]);
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i][1]==max) {
				temp++;
				arr.add(count[i][0]);
			}
		}
		
		Collections.sort(arr);
		
		if(temp > 1) {
			sb.append(arr.get(1)).append("\n");
		}else {
			sb.append(arr.get(arr.size()-1)).append("\n");
		}
		

		// 범위 출력
		sb.append(list.get(list.size() - 1) - list.get(0)).append("\n");

		System.out.println(sb);
	}
}