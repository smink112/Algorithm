import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static double x1, y1, r1;
	static double x2, y2, r2;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		x1 = Double.parseDouble(st.nextToken());
		y1 = Double.parseDouble(st.nextToken());
		r1 = Double.parseDouble(st.nextToken());
		x2 = Double.parseDouble(st.nextToken());
		y2 = Double.parseDouble(st.nextToken());
		r2 = Double.parseDouble(st.nextToken());

		double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		double S = 0.0;
		if (r1 + r2 < d) {
			S = 0.0;
		} else if (Math.abs(r1 - r2) >= d) {
			if (r1 > r2) {
				S = r2 * r2 * Math.PI;
			} else {
				S = r1 * r1 * Math.PI;
			}
		} 
		else {
			double theta1 = 2 * Math.acos((r1 * r1 + d * d - r2 * r2) / (2 * r1 * d));
			double theta2 = 2 * Math.acos((r2 * r2 + d * d - r1 * r1) / (2 * r2 * d));
			S = (r1 * r1) * (theta1 / 2 - Math.sin(theta1) / 2) + (r2 * r2) * (theta2 / 2 - Math.sin(theta2) / 2);
		}

		System.out.printf("%.3f", S);
	}
}