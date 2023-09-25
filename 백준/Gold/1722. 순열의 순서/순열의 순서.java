import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] ans = new int[21];
    static boolean[] visited = new boolean[21]; //방문 배열
    static long[] F = new long[21]; //팩토리얼 수를 저장한 배열

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        if (M == 1) {
            long K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {  //정답이 될 ans[i] 각 자리에 대해서
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) //방문한 수라면 넘어감
                        continue;
                    /*
                    N = 7이고 k번째 순열을 구한다면
                    N이 7이기 때문에 첫 번째 자리 수를 구하려면
                    k에서 6!을 계속 빼준다
                    만약 k에서 i번째 6!을 뺄 때 6!보다 작아진다면
                    그 i가 첫 번째 자리 수가 되는것이다.
                    이런 식으로 쭉쭉 7번째 자리수까지 구하다보면
                    k는 1이 되어있게 되는 것이다.
                     */
                    if (K <= cnt * F[N - i]) {  //현재 순번보다 (N−idx)! 작은 경우라면, 현재 자리 수에 숫자가 들어갈 수 있는 경우
                        K -= ((cnt - 1) * F[N - i]);
                        ans[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(ans[i] + " ");
            }
        } else {
            long K = 1;
            for (int i = 1; i <= N; i++) {
                ans[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < ans[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                K += cnt * F[N - i];
                visited[ans[i]] = true;
            }
            System.out.println(K);
        }
    }
}