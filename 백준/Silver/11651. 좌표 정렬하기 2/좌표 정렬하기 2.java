import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
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
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr, new Comparator<int[]>() { 
		    @Override
		    public int compare(int[] a1, int[] a2) {
		        return a1[1]!=a2[1] ? a1[1]-a2[1] : a1[0]-a2[0];
		    }
		});
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}