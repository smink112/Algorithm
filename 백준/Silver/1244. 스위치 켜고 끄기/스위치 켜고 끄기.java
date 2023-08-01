import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt();
		int[] switchArr = new int[switchNum];
		for (int i = 0; i < switchArr.length; i++) {
			switchArr[i] = sc.nextInt();
		}
		int studentNum;
		studentNum = sc.nextInt();

		for (int student_num = 0; student_num < studentNum; student_num++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			switch (gender) {
			case 1: // 남자인 경우
				for (int i = num - 1; i < switchArr.length; i += num) {
					switchArr[i] = (switchArr[i] == 1) ? 0 : 1;
				}
				break;

			case 2: // 여자인 경우
				int girl_switch = num - 1;
				
				switchArr[girl_switch] = (switchArr[girl_switch] == 1) ? 0 : 1;

				int d = 1;
				while (girl_switch + d < switchNum && num - d >= 1
						&& (switchArr[girl_switch - d] == switchArr[girl_switch + d])) {

					switchArr[girl_switch - d] = (switchArr[girl_switch - d] == 1) ? 0 : 1;
					switchArr[girl_switch + d] = (switchArr[girl_switch + d] == 1) ? 0 : 1;
					d++;

				}

			default:
				break;
			}
		}

		for (int i = 0; i < switchArr.length; i++) {
			System.out.print(switchArr[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}
}
