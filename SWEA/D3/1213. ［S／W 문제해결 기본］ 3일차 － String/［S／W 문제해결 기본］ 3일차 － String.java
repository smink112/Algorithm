import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;
    public static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
//      int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String sentence = br.readLine();
            int count = 0;
             
            for (int i = 0; i <= sentence.length()-s.length(); i++) {
                int temp = 0;
                for (int j = 0; j < s.length(); j++) {
                    if(sentence.charAt(i+j) != s.charAt(j)) {
                        break;
                    }else {
                        temp ++;
                    }
                    if (temp == s.length()) {
                        count++;
                    }
                }
            }
             
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
 
}