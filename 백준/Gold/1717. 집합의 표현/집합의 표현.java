import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {  // 대표 노드 초기화
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {   // 질의 계산 부분
            st = new StringTokenizer(br.readLine(), " ");
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check == 0) { // 합집합
                myUnion(a, b);
            } else if (check == 1) { // 들어있는지 확인
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }


    }

    private static void myUnion(int a, int b) {
        // 대표 노드를 찾아서 연결하기
        a = myFind(a);
        b = myFind(b);
        if (a != b) {
            parent[b] = a;
        }

    }

    private static int myFind(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            // parent[a] = myFind(parent[a]) 를 해줌으로써 경로 압축이 됨.
            return parent[a] = myFind(parent[a]);   // value를 index로 바꿔서 또 찾아보기
        }
    }

    private static boolean checkSame(int a, int b) {
        a = myFind(a);
        b = myFind(b);

        return a == b;
    }
}
