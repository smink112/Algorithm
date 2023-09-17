import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] room = new int[K];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        room[k -1] = e;
        sb.append("YES\n");

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            if(room[k-1] <= s){
                room[k-1] = e;
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
