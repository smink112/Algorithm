import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		char[] arr = br.readLine().toCharArray();

		int count = 0;
		int pipe = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == '(') {
				pipe++;
			} else if (arr[i] == ')' && arr[i - 1] == '(') {
				pipe--;
				count += pipe;
			} else if (arr[i] == ')' && arr[i - 1] == ')') {
				count += 1;
				pipe--;
			}
		}

		System.out.println(count);
	}

}