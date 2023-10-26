import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B;
    static int T;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];

            System.out.println(BFS());

        }
    }


    public static String BFS() {
        Queue<Register> q = new LinkedList<>();
        q.add(new Register(A, ""));
        visited[A] = true;

        while (!q.isEmpty()) {
            Register current = q.poll();

            if (current.num == B) {
                return current.str;
            }

            int D = (current.num * 2) % 10000;
            String Dstr = current.str + "D";
//            System.out.println(D + Dstr);
            if(!visited[D]) {
                q.add(new Register(D, Dstr));
                visited[D] = true;
            }

            int S = current.num - 1;
            if (S < 0) S = 9999;
            String Sstr = current.str + "S";
//            System.out.println(S + Sstr);
            if(!visited[S]) {
                q.add(new Register(S, Sstr));
                visited[S] = true;
            }

            int L1 = current.num/1000;
            int L2 = (current.num%1000)/100;
            int L3 = (current.num%100)/10;
            int L4 = (current.num%10);
            int L = L2*1000 + L3*100 + L4*10 + L1;
            String Lstr = current.str + "L";
//            System.out.println(L + Lstr);
            if (!visited[L]) {
                q.add(new Register(L, Lstr));
                visited[L] = true;
            }



            int R = L4*1000 + L1*100 + L2*10 + L3;
            String Rstr = current.str + "R";
            if(!visited[R]) {
                q.add(new Register(R, Rstr));
                visited[R] = true;
            }

        }

        return "";
    }

    static class Register {
        int num;
        String str;

        public Register(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}