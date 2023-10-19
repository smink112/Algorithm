import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] direction, distance;
    static int[][] arr;
    static boolean[][] rainy, newRainy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        newRainy = new boolean[N][N];
        rainy = new boolean[N][N];
        direction = new int[M];
        distance = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 2; i <= N - 1; i++) {
            for (int j = 0; j <= 1; j++) {
                rainy[i][j] = true;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            move(direction, distance);
            waterCopy();
            changeCloud();
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
//                System.out.print(arr[i][j] + " ");
                answer += arr[i][j];
            }
//            System.out.println();
        }

        bw.write(String.valueOf(answer));
        bw.close();

    }// main

    public static void move(int direction, int distance) {

        Queue<int[]> queue = new LinkedList<int[]>();

        distance %= N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rainy[i][j])
                    queue.offer(new int[] { i, j });
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];

            // 이동 후 구름의 row, col 저장
            int newRow = i + distance * dr[direction];
            int newCol = j + distance * dc[direction];
            // 만약 이동하는 위치가 경계선을 넘어갈 때
            int newDistance = 0;
            int newDirection = 0;
            if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= N) {
                // 좌로 3칸을 가는 경우 == 우로 N-3칸을 가는 경우가 됨
                // 방향은 반대가 되고 거리는 N-distance가 된다고 생각하면 됨
                newDistance = N - (distance % N);
                if (direction <= 4)
                    newDirection = direction + 4;
                else if (direction > 4)
                    newDirection = direction - 4;

                // 경계선 조건에 의해 바뀐 값 재정의

                newRow = i + newDistance * dr[newDirection];
                newCol = j + newDistance * dc[newDirection];
            }
//            System.out.println(newRow + " " + newCol);
            if(newRow<0) newRow += N;
            if(newCol<0) newCol += N;
            newRainy[newRow%N][newCol%N] = true;
            arr[newRow%N][newCol%N]++;
        }

        for(int i=0; i<rainy.length; i++) {
            Arrays.fill(rainy[i], false);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                rainy[i][j] = newRainy[i][j];
            }
            Arrays.fill(newRainy[i], false);
        }


    }

    public static void waterCopy() {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!rainy[i][j]) continue;

                for(int k=2; k<=8; k+=2) {
                    if(i+dr[k]<0 || j+dc[k]<0 || i+dr[k]>=N || j+dc[k]>=N) continue;
                    if(arr[i+dr[k]][j+dc[k]] > 0) arr[i][j]++;
                }
            }
        }
    }

    public static void changeCloud() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!rainy[i][j] && arr[i][j] >= 2) {
                    rainy[i][j] = true;
                    arr[i][j] -= 2;
                } else if(rainy[i][j]) rainy[i][j] = false;
            }
        }
    }
}