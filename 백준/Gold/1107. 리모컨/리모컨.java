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
		sb = new StringBuilder();
		int channelWant = Integer.parseInt(br.readLine());
		int noButtonN = Integer.parseInt(br.readLine());
		ArrayList<Integer> noButton = new ArrayList<Integer>();
		if (noButtonN != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < noButtonN; i++) {
				noButton.add(Integer.parseInt(st.nextToken()));
			}
		}

		int answer = Math.abs(100 - channelWant); // 위아래만 움직이는게 최소이면서 정답일 수도 있으니까

		int min = Integer.MAX_VALUE;
		int count = 0;

		outer: for (int j = 0; j < 1000000; j++) {
			String s = String.valueOf(j);
			for (int i = 0; i < s.length(); i++) {
				if (noButton.contains(s.charAt(i) - '0')) { // 못 누르면 다음껄로
					continue outer;
				}
			}

			count = s.length() + Math.abs(j - channelWant); // 누를수 있으면 누르고 채널 차이만큼 위아래 이동

			if (count < min) {
				min = count;
			}
		}

		if (min < answer)
			answer = min;

		sb.append(answer);

		System.out.println(sb);
	}
}