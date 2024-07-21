import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, num;
    static int max_a = 0, a_idx = 0, max_b = 0, b_idx = 0;

    public static void main(String[] args) throws IOException {

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            a.add(num);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            num = Integer.parseInt(st.nextToken());
            b.add(num);
        }

        boolean flag = true;
        List<Integer> ans = new ArrayList<>();

        while (true) {
            // 각 수열의 공통되는 최댓값 찾기
            while (true) {
                if (a.isEmpty() || b.isEmpty()) {
                    flag = false;
                    break;
                }
                max_a = Collections.max(a);
                a_idx = a.indexOf(max_a);
                max_b = Collections.max(b);
                b_idx = b.indexOf(max_b);

                if (max_a == max_b) break;
                else if (max_a > max_b) a.remove(a_idx);
                else b.remove(b_idx);
            }
            if (!flag) break;

            ans.add(max_a);

            // 최댓값 보다 작은 인덱스의 값들을 제거
            a = a.subList(a_idx + 1, a.size());
            b = b.subList(b_idx + 1, b.size());
        }

        if (!ans.isEmpty()) {
            System.out.println(ans.size());
            for (int v : ans) {
                System.out.print(v + " ");
            }
        } else {
            System.out.println(0);
        }

    }
}