import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    static int N;
    static List<Node>[] list;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char v = s.charAt(0);
            char left = s.charAt(2);
            char right = s.charAt(4);
            list[v-'A'].add(new Node(left, right));
        }

        read(0);

        System.out.println(pre + "\n" + in + "\n" + post);
    }

    static void read(int n){
        for(Node node : list[n]) {
            char l = node.left;
            char r = node.right;

            pre.append((char)(n+'A'));
            if(l != '.') read(l-'A');
            in.append((char)(n+'A'));
            if(r != '.') read(r - 'A');
            post.append((char)(n+'A'));
        }

    }

    static class Node{
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}