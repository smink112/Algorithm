import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		String s = null;
		s = br.readLine();
		st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		
		for (int i = 1; i < arr.length; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		int[] sumArr = new int[4];	// 0 : x1, 1 : y1, 2 : x2,  3 : y2
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			sumArr[0] = Integer.parseInt(st.nextToken());
			sumArr[1] = Integer.parseInt(st.nextToken());
			sumArr[2] = Integer.parseInt(st.nextToken());
			sumArr[3] = Integer.parseInt(st.nextToken());
			
			int temp = 0;
			
			for (int j = sumArr[0]; j <= sumArr[2] ; j++) {
				temp += arr[j][sumArr[3]] - arr[j][sumArr[1] - 1];
			}
			
			sb.append(temp + "\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
