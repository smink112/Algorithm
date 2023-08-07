import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int max = 0, min = 256;
		int time = Integer.MAX_VALUE, floor = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
				min = Math.min(min, arr[i][j]);
			}
		}
		
//		System.out.println(max + " " + min);

		outer : for (int height = min; height <= max; height++) {
            int del_count = 0;
            int ins_count = 0;
            int temp_b = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] < height) {
                        ins_count += height - arr[i][j];
                        temp_b -= height - arr[i][j];
                    } else if (arr[i][j] > height) {
                        del_count += arr[i][j] - height;
                        temp_b += arr[i][j] - height;
                    }
                }
            }
            if (temp_b < 0) {
                continue outer;
            }
            int t = del_count * 2 + ins_count;
            if (t <= time && height >= floor) {
                time = t;
                floor = height;
            }
        }

		System.out.printf("%d %d", time, floor);
	}
}
