import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int test = 1;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int tree = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && checkTree(i)) {
                    tree++;
                }
            }
            bw.write("Case " + test + ": ");

            if (tree > 1) {
                bw.write("A forest of " + tree + " trees.");
            } else if (tree == 1) {
                bw.write("There is one tree.");
            } else {
                bw.write("No trees.");
            }
            bw.write("\n");

            test++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkTree(int root) {
        Queue<Integer> qu = new LinkedList<>();
        int node = 0;
        int edge = 0;

        qu.add(root);

        while (!qu.isEmpty()) {
            int cn = qu.poll();

            if (visited[cn]) continue;
            visited[cn] = true;
            node++;

            for (int i = 0; i < graph.get(cn).size(); i++) {
                int nn = graph.get(cn).get(i);
                edge++;
                if (!visited[nn]) {
                    qu.add(nn);
                }
            }
        }

        // 무방향 그래프 이므로 (e/2)해야 함
        return (edge / 2) + 1 == node ? true : false;
    }

}