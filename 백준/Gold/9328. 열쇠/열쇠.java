import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int height, width, count;
    static char[][] map;
    static boolean[] key;
    static ArrayList<Point>[] gates;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());

            map = new char[height+2][width+2];
            visited = new boolean[height+2][width+2];
            key = new boolean[26];
            gates = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                gates[i] = new ArrayList<>();
            }

            count = 0;

            for (int i = 0; i < height + 2; i++) {
                for (int j = 0; j < width + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= height; i++) {
                String input = br.readLine();
                for (int j = 1; j <= width; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String s = br.readLine();
            char[] temp = s.toCharArray();
            if (temp[0] != '0'){
                for (int i = 0; i < s.length(); i++) {
                    key[temp[i]-'a'] = true;
                }
            }
            bfs();

            System.out.println(count);

        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= height + 2 || ny >= width + 2) {
                    continue;
                }

                if (map[nx][ny] == '*' || visited[nx][ny]) {
                    continue;
                }

                int elem = map[nx][ny];
                if (elem - 'A' >= 0 && elem - 'A' <= 25) {
                    if (key[elem - 'A']) {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    } else {
                        gates[elem - 'A'].add(new Point(nx, ny));
                    }
                } else if (elem - 'a' >= 0 && elem - 'a' <= 25) {
                    key[elem - 'a'] = true;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));

                    for (int j = 0; j <= 25; j++) {
                        if (gates[j].size() != 0 && key[j]) {
                            for (int z = 0; z < gates[j].size(); z++) {
                                Point temp = gates[j].get(z);
                                map[temp.x][temp.y] = '.';
                                visited[temp.x][temp.y] = true;
                                q.add(new Point(temp.x, temp.y));
                            }
                        }
                    }
                } else if (elem == '$') {
                    count++;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                } else {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }

            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}