import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {return o2-o1;});
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && q.isEmpty()){
                sb.append(0).append("\n");
            }else if(num == 0){
                sb.append(q.poll()).append("\n");
            }else {
                q.offer(num);
            }
        }
        System.out.println(sb);
    }
}