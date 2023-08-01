import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 	 
		Scanner sc = new Scanner(System.in);
		int[][] whole = new int[100][100];
		int paper_count = sc.nextInt();
		int x = 0, y = 0;
		int count = 0;
		
		for (int i = 0; i < paper_count; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for (int addx = 0; addx < 10; addx++) {
				for (int addy = 0; addy < 10; addy++) {
					whole[x+addx][y+addy] +=1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(whole[i][j] != 0) count++;
			}
		}
		
		System.out.println(count);
	}
}
