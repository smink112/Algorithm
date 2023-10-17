import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, Max = 0;
    static int[] arr;
    static ArrayList<Integer> dp_asc;
    static ArrayList<Integer> dp_desc;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp_asc = new ArrayList<>();
        dp_desc = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            asc(arr[i]);
            for (int j = i + 1; j < N; j++) {
                desc(arr[j]);
            }
//            System.out.print(dp_asc);
//            System.out.println(dp_desc);
            Max = Math.max(Max, dp_asc.size() + dp_desc.size());
            dp_desc.clear();
        }

        System.out.println(Max);

    }//main

    public static void asc(int n) {
        if (dp_asc.isEmpty()) {
            dp_asc.add(n);

        }
        int left = 0, right = dp_asc.size() - 1, mid;

        if (dp_asc.get(right) < n) {//N이 저장되어있는 리스트 맨 뒤 숫자보다 크면 삽입
            dp_asc.add(n);
            return;
        }
        //N이 저장되어있는 리스트 맨 뒤 숫자보다 작을떄
        while (left <= right) {
            mid = (left + right) / 2;
            if (n == dp_asc.get(mid)) { //N이 배열의 중앙과 값이 같다면
                return;
            } else if (n < dp_asc.get(mid)) {//N이 배열의 중앙보다 작다면
                right = mid - 1;
            } else {//N이 배열의 중앙보다 작다면
                left = mid + 1;
            }
        }

        dp_asc.set(left, n);

    }//asc

    public static void desc(int n) {
        if (dp_desc.isEmpty() && n < dp_asc.get(dp_asc.size() - 1)) {
            dp_desc.add(n);

        }

        if (dp_desc.isEmpty() || n == dp_asc.get(dp_asc.size() - 1)) return;

        int left = 0, right = dp_desc.size() - 1, mid;

        if (dp_desc.get(right) > n ) {//N이 저장되어있는 리스트 맨 뒤 숫자보다 작으면 삽입
            dp_desc.add(n);
            return;
        }


        //N이 저장되어있는 리스트 맨 뒤 숫자보다 클때
        while (left <= right) {
            mid = (left + right) / 2;
            if (n == dp_desc.get(mid)) { //N이 배열의 중앙과 값이 같다면
                return;
            } else if (n < dp_desc.get(mid)) {//N이 배열의 중앙보다 작다면
                left = mid + 1;
            } else {//N이 배열의 중앙보다 작다면
                right = mid - 1;
            }
        }

        dp_desc.set(left, n);

    }//desc
}