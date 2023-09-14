import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, M;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        N = scan.nextInt();
        M = scan.nextInt();
 
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int cost = scan.nextInt();
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }
 
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, 50000001); //50000 * 1000 + 1
        dijkstra();
        System.out.println(dist[N]); //목적지는 n
    }
 
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0; //시작 지점은 1
        //현재 노드 번호, 거리
        q.offer(new Node(1, 0));
 
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            if(!visited[current.d]) visited[current.d] = true;
            else continue;
 
            for(int i = 0; i < list[current.d].size(); i++) {	//현재 노드와 연결된 애들에 대해서 다 봐야함
                Node next = list[current.d].get(i);	// 갈 수 있는 다음 노드는 현재 노드 리스트에 저장된 애들
              //다음 노드까지 가는데 걸리는 최소 거리가 저장된 거리가     현재 노드에 저장되어있는 거리 + 현재노드에서 다음노드까지 걸리는 거리보다 크다면
                if(dist[next.d] > dist[current.d] + next.cost) {
                	// 다음 노드까지 가는 최소거리를 현재 노드에 저장되어있는 거리 + 현재노드에서 다음노드까지 걸리는 거리로 바꿔줌
                    dist[next.d] = dist[current.d] + next.cost;
                    // 다음 노드 번호와 다음 노드의 거리를 넘겨줌 -> 다음 사이클에서 현재 노드번호가 되기 위해
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int d;
        int cost;
 
        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}