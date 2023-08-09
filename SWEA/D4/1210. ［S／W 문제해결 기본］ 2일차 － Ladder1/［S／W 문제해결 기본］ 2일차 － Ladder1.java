import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];
            int row = 0, col = 0;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (ladder[i][j] == 2) {
                        row = i;
                        col = j;
                    }
                }
            }
             
            while (row != 0) {
                if (col-1 >= 0 && ladder[row][col - 1] != 0) {
                    while(col-1 >= 0 && ladder[row][col - 1] != 0) {
                        col--;
                    }
                    row--;
                } else if (col+1 < 100 && ladder[row][col + 1] != 0) {
                    while(col+1 < 100 && ladder[row][col + 1] != 0) {
                        col++;
                    }
                    row--;
                } else {
                    row--;
                }
            }
 
            sb.append("#").append(test_case).append(" ").append(col).append("\n");
        }
        System.out.println(sb);
    }
}