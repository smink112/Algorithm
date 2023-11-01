import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int F, Start, G, Up, Down;
    static boolean[] floor;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        Start = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        Up = Integer.parseInt(st.nextToken());
        Down = Integer.parseInt(st.nextToken());

        floor = new boolean[F+1];
        int count = BFS();
        System.out.println(count != -1 ? count : "use the stairs");
    }

    public static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {Start, 0});
        floor[Start] = true;

        while (!q.isEmpty()){
            int[] temp = q.poll();

            if (temp[0] == G){
                return temp[1];
            }

            int UpFloor = temp[0] + Up;
            int DownFloor = temp[0] - Down;

            if(UpFloor != temp[0] && UpFloor <= F && !floor[UpFloor]){
                q.offer(new int[] {UpFloor, temp[1]+1});
                floor[UpFloor] = true;
            }
            if(DownFloor != temp[0] && DownFloor >= 1 && !floor[DownFloor]){
                q.offer(new int[] {DownFloor, temp[1]+1});
                floor[DownFloor] = true;
            }
        }

        return -1;
    }
}