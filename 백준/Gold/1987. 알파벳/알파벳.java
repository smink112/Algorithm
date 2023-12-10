import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, Max;
    static char[][] map;
    static boolean[] visited = new boolean[26]; //알파벳 갯수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Node node = new Node(0,0);
        if (N == 1 && M == 1){
            System.out.println(1);
        }else{
            dfs(node, 0);
            System.out.println(Max);
        }

    }   //main

    static void dfs(Node node, int count){
        if (visited[map[node.r][node.c] - 'A']){
            Max = Math.max(Max, count);
        }else {
            visited[map[node.r][node.c] - 'A'] = true;
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if(nr>=N || nr <0 || nc >= M || nc <0) continue;
                dfs(new Node(nr,nc), count + 1);
            }
            visited[map[node.r][node.c] - 'A'] = false;
        }
    }

    static class Node{
        private int r;
        private int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}