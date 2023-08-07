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
		long count = 0;

		for (int building = 0; building < N; building++) {
			int temp = Integer.parseInt(br.readLine());

			if (arr.isEmpty() || arr.get(arr.size() - 1) > temp) {
				count += arr.size();
				arr.add(temp);
			} else {
				while (!arr.isEmpty() && arr.get(arr.size() - 1) <= temp) {
					arr.remove(arr.size() - 1);
				}
				count += arr.size();
				arr.add(temp);
			}
		}

		System.out.println(count);
	}
}