import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static long Ans = 0;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Jwel[] jwels = new Jwel[N];
        bag = new int[K];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            jwels[i] = new Jwel(m, cost);
        }

        Arrays.sort(jwels, new Comparator<Jwel>() {
            @Override
            public int compare(Jwel o1, Jwel o2) {
                if (o1.m == o2.m) {
                    return o2.cost - o1.cost;
                }
                return o1.m - o2.m;
            }
        });

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }

        Arrays.sort(bag);

        // 우선순위 큐는 항상 가격이 내림차순 정렬되도록 설정.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < N && jwels[j].m <= bag[i]) {
                pq.offer(jwels[j++].cost);
            }

            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                Ans += pq.poll();
            }
        }

        System.out.println(Ans);
    }
    static class Jwel {
        int m;
        int cost;

        public Jwel(int m, int cost) {
            this.m = m;
            this.cost = cost;
        }
    }
}