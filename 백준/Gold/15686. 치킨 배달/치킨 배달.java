import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, min = Integer.MAX_VALUE;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> home = new ArrayList<>();
    static Node[] live;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 2) {
                    chicken.add(new Node(r, c));
                } else if (temp == 1) {
                    home.add(new Node(r, c));
                }

            }
        }

        live = new Node[M];
        combination(0, 0);
        System.out.println(min);

    }

    public static void combination(int start, int depth) {
        if (depth == M) {
            chickenDistance();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            live[depth] = new Node(chicken.get(i).r, chicken.get(i).c);
            combination(i + 1, depth + 1);
        }
    }

    private static void chickenDistance() {
        int res = 0;

        for(int i=0; i<home.size(); i++) {
            int home_min = Integer.MAX_VALUE;
            for(int j=0; j<M; j++) {
                home_min = Math.min(home_min, Math.abs(home.get(i).r - live[j].r) + Math.abs(home.get(i).c - live[j].c));
            }
            res += home_min;
        }
        min = Math.min(min, res);
    }

}

class Node {
    int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}