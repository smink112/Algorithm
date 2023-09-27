import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (min < arr[i]) min = arr[i] ;
            max += arr[i];
        }

        int mid = 0, cur = 0;
        int ans = Integer.MAX_VALUE;
        int count = 1;

        while (min <= max) {
            count = 0;
            cur = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < N; i++) {
                if (cur >= arr[i]) {
                    cur -= arr[i];
                } else {
                    count++;
                    cur = mid;
                    cur -= arr[i];
                }
            }
//            System.out.println(count + " " + min + " " + max);

            if (count > M) {
                ans = mid;
                min = mid + 1;
            }
            else {
                ans = mid;
                max = mid -1;
            }

        }

        bw.write(String.valueOf(ans));
        bw.close();


    }//main
}