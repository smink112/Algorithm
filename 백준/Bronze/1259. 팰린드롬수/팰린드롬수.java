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
		String s = br.readLine();
		sb = new StringBuilder();
		
		while(Integer.parseInt(s) != 0) {
			char[] arr = s.toCharArray();
			
			sb.append(isPalindrome(arr)).append("\n");
			
			s = br.readLine();
		}
		
		System.out.println(sb);
	}
	
	public static String isPalindrome(char[] arr) {
		boolean yn = true;
		
		if(arr.length % 2 == 1) {	// 숫자 개수가 홀수
			for (int i = 1; i < arr.length/2+1; i++) {
				if(arr[(arr.length/2) - i] != arr[(arr.length/2) + i]) {	//다르다면 끝
					yn = false;
					break;
				}
			}
		}else if(arr.length % 2 == 0) {						// 숫자 개수가 짝수
			for (int i = 0; i < arr.length/2; i++) {
				if(arr[(arr.length/2) - i - 1] != arr[(arr.length/2) + i ]) {	//다르다면 끝
					yn = false;
					break;
				}
			}
		}
		
		return yn? "yes" : "no"; 
	}
}