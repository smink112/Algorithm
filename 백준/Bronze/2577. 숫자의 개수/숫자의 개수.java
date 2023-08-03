import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
//		String s = br.readLine();
//		st = new StringTokenizer(s);
//		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int Mul = A * B * C;
		
		String str = String.valueOf(Mul);
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if(Character.getNumericValue(arr[j]) == i) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
