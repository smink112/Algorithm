import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		char[] arr = s.toCharArray();
		int[] count = new int[26];
		int temp = 0, max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 65 && arr[i]<=90) {
				count[arr[i]-65]++;
			}else if(arr[i]>=97 && arr[i]<=122) {
				count[arr[i]-97]++;
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);
			if (max == count[i])	temp = i;
		}
		
		int maxcount = 0;
		for (int i = 0; i < count.length; i++) {
			if(max == count[i]) {
				maxcount++;
			}
		}
		
		if(maxcount > 1) {
			System.out.println("?");
		}else {
			System.out.printf("%c", temp+65);
		}
		
	}
}