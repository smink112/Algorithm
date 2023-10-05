import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long A, B;
    static int Min;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        Min = Integer.MAX_VALUE;

        if(A == B){
            System.out.println(0);
        }else {
            System.out.println(BFS());
        }
    }

    static int BFS() {
        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{A, 1});

        while (!q.isEmpty()) {
            long[] temp = q.poll();
            if (temp[0] == B) {
                Min = Math.min(Min, (int)temp[1]);
            }
            if (temp[0] * 2 <= B) {
                q.offer(new long[]{temp[0] * 2, temp[1] + 1});
            }
            if (temp[0] * 10 + 1 <= B) {
                q.offer(new long[]{temp[0] * 10 + 1, temp[1] + 1});
            }

        }

        return Min == Integer.MAX_VALUE ? -1 : Min;
    }
}