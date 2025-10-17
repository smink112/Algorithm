import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer> A;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int good = 0;
        
        A = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        for (int i = 0; i < N; i++) {
            int target = A.get(i);
            int a = 0;
            int b = N - 1;
            while (a < b) {
                if (A.get(a) + A.get(b) == target) {
                    if (a != i && b != i) {
                        good++;
                        break;
                    } else if (a == i) {
                        a++;
                    } else if (b == i) {
                        b--;
                    }
                } else if (A.get(a) + A.get(b) < target) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        System.out.println(good);
    }
}
