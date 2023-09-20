import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb;
    public static StringTokenizer st;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] island = new int[N][2];
            parent = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());
            ArrayList<Edge> edgeList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long distX = Math.abs(island[i][0] - island[j][0]);
                    long distY = Math.abs(island[i][1] - island[j][1]);
                    edgeList.add(new Edge(i, j, distX * distX + distY * distY));
                }
            }

            edgeList.sort(null);

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int count = 0;
            long res = 0;
            for (Edge edge : edgeList) {
                if (union(edge.v, edge.u)) {
                    res += edge.cost;
                    if (++count == N - 1) break;
                }
            }

            sb.append("#").append(test_case).append(" ").append(Math.round(res * E)).append("\n");
        }

        System.out.println(sb);
    }


    static class Edge implements Comparable<Edge> {
        private int v;
        private int u;
        private long cost;

        public Edge(int v, int u, long cost) {
            this.v = v;
            this.u = u;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }

    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}