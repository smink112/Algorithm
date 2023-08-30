import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    static int N, L, maxScore = 0;
    static int[][] ingredient;
     
    public static void hamburger(int idx, int score, int cal) {
        if (cal <= L) maxScore = Math.max(maxScore, score);
        if (idx == N || cal > L) return;
         
        hamburger(idx + 1, score + ingredient[idx][0], cal + ingredient[idx][1]);
        hamburger(idx + 1, score, cal);
    }
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++){
            maxScore = 0;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
             
            ingredient = new int[N][2];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ingredient[i][0] = Integer.parseInt(st.nextToken());
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }
             
            hamburger(0, 0, 0);
             
            System.out.println("#" + test_case + " " + maxScore);
        }
    }
}