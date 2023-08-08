import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(arr,arr2[i])).append("\n");
		}

		System.out.println(sb);
	}
	
	public static int binarySearch(int[] arr, int searchNum) {
		int start = 0;
		int end = arr.length-1;
		int index = (start+end)/2;
		
		
		while (start <= end) {

			if (arr[index] == searchNum) {
				return 1;
			}
			else if (arr[index] < searchNum) {
				start = index+1;
			}
			else if (arr[index] > searchNum) {
				end = index-1;
			}
			index = (start+end)/2;
		}
		return 0;
	}
}
