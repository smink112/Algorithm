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

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int[] array = new int[N];
		int[] result = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			array[i] = Integer.parseInt(br.readLine());
			max = Math.max(array[i], max);
		}
		
		int[] counting_array = new int[max + 1];
		
		for(int i = 0 ; i < array.length ; i++) {
			counting_array[array[i]]++;
		}
		
		for(int i = 1 ; i < counting_array.length ; i++) {
			counting_array[i] += counting_array[i-1];
		}
		
		for(int i = array.length - 1 ; i >= 0 ; i--) {
			result[--counting_array[array[i]]] = array[i];
		}
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(result[i]) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
}