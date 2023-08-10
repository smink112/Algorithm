import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		double nope = Math.round(N*0.15);
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		for (int i = 0; i < N; i++) {
			list.add(Double.parseDouble(br.readLine()));
		}
		
		Collections.sort(list);
		
		double sum = 0;
		for (int i = (int)nope; i < list.size()- (int)nope; i++) {
			sum += list.get(i);
		}
		
		bw.write(Math.round(sum/(list.size()-(int)nope*2))+"");
		bw.flush();
		bw.close();
		
	}
}