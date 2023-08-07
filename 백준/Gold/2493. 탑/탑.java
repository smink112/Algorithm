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
		ArrayList<Integer> indexArr = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int index = 1;

		while (st.hasMoreElements()) {
			int temp = Integer.parseInt(st.nextToken());

			if (!arr.isEmpty() && arr.get(arr.size() - 1) < temp) {
				outer: for (int i = 1; i <= arr.size(); i++) {
					while (arr.get(arr.size() - i) < temp) {
						arr.remove(arr.size() - 1);
						indexArr.remove(indexArr.size() - 1);
						if (arr.isEmpty())
							break;
					}
					if (arr.isEmpty()) {
						arr.add(temp);
						indexArr.add(index);
						index++;
						sb.append(0 + " ");
						break outer;
					} else {
						arr.add(temp);
						sb.append(indexArr.get(indexArr.size() - 1) + " ");
						indexArr.add(index);
						index++;
						break outer;
					}
				}

			} else {
				if (arr.isEmpty()) {
					arr.add(temp);
					indexArr.add(index);
					index++;
					sb.append(0 + " ");
				} else {
					arr.add(temp);
					sb.append(indexArr.get(indexArr.size() - 1) + " ");
					indexArr.add(index);
					index++;
				}
			}
		}
		System.out.println(sb);
	}
}