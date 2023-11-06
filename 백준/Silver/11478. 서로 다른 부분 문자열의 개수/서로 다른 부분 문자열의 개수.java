import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = 1; j <= S.length()-i; j++) {
                set.add(S.substring(i,j+i));
            }
        }

        System.out.println(set.size());


    }
}