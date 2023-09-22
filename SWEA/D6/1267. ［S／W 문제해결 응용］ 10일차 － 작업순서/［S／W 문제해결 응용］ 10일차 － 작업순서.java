import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int V, E;
    static int[][] adjArr;
    static int[] degree;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            V = sc.nextInt();
            E = sc.nextInt();

            // 인접행렬
            adjArr = new int[V + 1][V + 1]; // why? 문제에서 1번 정점부터 시작 V번까지
            degree = new int[V + 1]; // 진입차수를 저장할 배열을 하나 생성한다.
            visited = new boolean[V + 1];

            stack = new Stack<>();

            for (int i = 0; i < E; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                // 유향이므로 A->B로만 저장하면 되겠다~~~
                adjArr[A][B] = 1; // 가중치가 따로 주어지지 않았기 때문에
                // 진입차수를 증가~~
                degree[B]++;
            } // 입력이 모두 완료가 되었다.

            // 진입차수가 0인 원소들을 가지고 출발~~
            for (int i = 1; i < V + 1; i++) {
                if (degree[i] == 0)
                    DFS(i);
            }

            System.out.print("#" + test_case + " ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    private static void DFS(int v) {
        visited[v] = true; // 현재 정점 방문쳌

        for (int i = 1; i < V + 1; i++) {
            // 인접하지만 방문하지 않은 정점들을 방문하겠다.
            if (adjArr[v][i] == 1 && !visited[i])
                DFS(i); // 깊이우선탐색
        }

        stack.add(v);
    }
}