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
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int count = 0;
		boolean flag = false;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < arr.length; i++) {
			int max = 0, idx = -1;
			for (int j = 0; j < arr.length-i; j++) {
				max = Math.max(max, arr[j]);
				if(max == arr[j])	idx = j;
			}
			if(max!= arr[arr.length -1 -i]) {
				int temp = arr[idx];
				arr[idx] = arr[arr.length-1-i];
				arr[arr.length -1 -i] = temp;
				count++;
				if(count == K) {
					sb.append(arr[idx]).append(" ").append(arr[arr.length-1-i]);
					flag = true;
					break;
					
				}
			}
		}
		if(!flag) {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}