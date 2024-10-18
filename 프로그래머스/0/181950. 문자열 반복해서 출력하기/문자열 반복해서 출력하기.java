import java.io.*;
import java.util.*;

public class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String s = st.nextToken();
        int a = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < a; i++){
            System.out.print(s);
        }

    }
}