import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int max =0, min = 1000;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		int count = 0;
		int[] result = new int[N]; 
		for (int i = min; i <= max; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == i) {
					result[j] = count++;
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
}
