import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int N;
    static int[] people;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N+1];
        
        for (int i = 1; i < people.length; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // 0번째
        
        for (int i = 1; i < N+1; i++) {
            graph.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
        
            for (int n = 0; n < temp; n++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        List<Integer> vote1 = new ArrayList<>();
        List<Integer> vote2    = new ArrayList<>();
        
        divide(1, vote1, vote2);
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }
    
    public static void divide(int index, List<Integer> vote1, List<Integer> vote2) {
        if (index == N+1) {
            if (!vote1.isEmpty() && !vote2.isEmpty() && bfs(vote1) && bfs(vote2)) {
                min = Math.min(min, Math.abs(sum(vote1) - sum(vote2)));
            }
            return;
        }
        
        vote1.add(index);
        divide(index+1, vote1, vote2);
        vote1.remove(vote1.size()-1);
        
        vote2.add(index);
        divide(index+1, vote1, vote2);
        vote2.remove(vote2.size()-1);
    }
    
    public static boolean bfs(List<Integer> vote) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[vote.size()];
        q.offer(0);
        vis[0] = true;
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < vote.size(); i++) {
                if (graph.get(vote.get(temp)).contains(vote.get(i)) && !vis[i] ) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        
        boolean check = true;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                check = false;
                break;
            }
        }
        return check;
    }
    
    public static int sum(List<Integer> vote) {
        int a = 0;
        for (int i = 0; i < vote.size(); i++) {
            a += people[vote.get(i)];
        }
        return a;
    }
}