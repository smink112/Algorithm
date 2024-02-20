import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T =  Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            String s = br.readLine();
            char arr[] = s.toCharArray();

            System.out.printf("%c%c\n",arr[0],arr[s.length()-1]);
        }
    }

}