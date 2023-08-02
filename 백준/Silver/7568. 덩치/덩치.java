import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		String s = null;
		int[][] arr = new int[N][2];	// 0 : 몸무게, 1 : 키
		
		
		for (int i = 0; i < arr.length; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][1] > arr[i][1] && arr[j][0] > arr[i][0]) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
	}
}
