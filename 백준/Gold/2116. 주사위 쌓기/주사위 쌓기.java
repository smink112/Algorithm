import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	static int N, max;
	static int[][] dice;
	static int[] op = { 5, 3, 4, 1, 2, 0 };
	// 0번 인덱스는 5번을 마주보고, 1번은3번, 2번은 4번을 마주봄

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		dice = new int[N][6];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++) {
			int tempMax = 0;
			for (int j = 0; j < 6; j++) {
				if (j == i || j == op[i])
					continue;
				tempMax = Math.max(tempMax, dice[0][j]);
			}
			makeTower(dice[0][i], tempMax, 1);	//모든 면에 대해서 실행해야지. -> 각 면을 다 실행하긴 할껀데 어차피 최대값은 max에 저장될꺼임.
		}

		System.out.println(max);

	}

	public static void makeTower(int diceUp, int sum, int count) {
		if (count == N) {
			max = Math.max(sum, max);
			return;
		}
		int thisDownIndex = 0;
		for (int i = 0; i < 6; i++) {
			if (dice[count][i] == diceUp) {// 쌓여있는 주사위 위랑 숫자가 일치하면 그때의 인덱스가 지금 쌓으려는 주사위의 인덱스
				thisDownIndex = i;
				break;
			}
		}
//		int thisDown = diceUp;	//이건 당연한소리지; 애초에 같아서 인덱스를 찾은건데
		int thisUpIndex = op[thisDownIndex]; // 아래 맞은편 인덱스 : 위쪽 인덱스
		int tempMax = 0;
		for (int i = 0; i < 6; i++) {
			if (i == thisUpIndex || i == thisDownIndex)	//찾으려는애가 밑이나 위면 안되니깐.
				continue;
			tempMax = Math.max(tempMax, dice[count][i]);//인덱스가 아닌애들 중에서 최대값을 찾아봐...
		}
		makeTower(dice[count][thisUpIndex], sum + tempMax, ++count);	//다음주사위로 넘어가기..?

	}
}