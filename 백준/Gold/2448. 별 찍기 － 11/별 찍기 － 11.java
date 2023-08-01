import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());
		int K = (int) baseLog(N/3, 2.0);
		
		String[] line = new String[N];	//N줄만큼 받는다
		// k = 0일때, 기본 형태
		line[0] = "  *  ";
		line[1] = " * * ";
		line[2] = "*****";
		
		for (int i = 1; i <= K; i++) {	//K가 0일때는 실행하지 않음 : 이미 저해뒀으니까 앞,뒤로 공백만 더 추가할 수 있게끔 해주면 됨
			makeStar(i, line);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(line[i]);
		}

	}

	public static void makeStar(int K, String[] line) {
		int bottom = 3 * (int)Math.pow(2, K);	// 맨 밑줄 크기
		int middle = bottom / 2;				// 중간 시작점

		for (int i = middle; i < bottom; ++i) {	// 중간 시작점부터 밑줄 크기까지
			line[i] = line[i - middle] + " " + line[i - middle]; // 이전 *블럭 + 공백 + *블럭
		}
		String space = "";
		for(int i = 0; i < middle; i++) {
			space += " ";
		}
		for (int i = 0; i < middle; ++i) {	// 중간점이 올때까지 공백 + 이전 *출력 + 공백 저장
			line[i] = space + line[i] + space;
		}
	}
	
	static double baseLog(double X, double base) {
		return Math.log10(X) / Math.log10(base);
	}
}
