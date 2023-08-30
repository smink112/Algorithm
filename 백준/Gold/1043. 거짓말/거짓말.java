import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static boolean[] knows;
	static int count = 0;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 총 파티 참가 인원 수
		int M = Integer.parseInt(st.nextToken()); // 파티 개최 수
		
		HashSet<Integer>[] party = new HashSet[M];
		for (int i = 0; i < M; i++) {
            party[i] = new HashSet<>();
        }

		st = new StringTokenizer(br.readLine()); // 아는사람수 + 누가 아는지 들어옴
		int Know = Integer.parseInt(st.nextToken()); // 아는 사람 수
		if (Know == 0) {
			System.out.println(M); // 아는사람이 없다면 그냥 개최수 만큼 구라깔 수 있음
			return;
		}

		knows = new boolean[N+1];	//0번 사람은 없는거고/////1번사람~ N번 사람까지

		for (int i = 1; i <= Know; i++) { // 알고 있는애들 knows boolean배열 true로 바꿔줘야함
			int temp = Integer.parseInt(st.nextToken());
			knows[temp] = true;
		}
		
		parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

		for (int i = 0; i < M; i++) { // 파티 개최 수
			String[] inputs = br.readLine().split(" ");
			int p = Integer.parseInt(inputs[0]);	//해당 파티에 몇명이 오는지
			if(p<=1) {
                party[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < p; j++) { // 연관 관계 이어줌
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }

                party[i].add(a); // 파티에 참여하는 사람 저장
                party[i].add(b);
            }
		}
		
		 // 진실을 아는 사람과 연관 관계 있음 -> know[i] true로 변경
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(knows[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= N; j++){
                    if (find(j)==root) {
                        knows[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
		
		// 모든 파티 참석자가 flase여야 구라 가능
        for (int i = 0; i < M; i++) { // party[i]
            boolean flag = false;
            for (int person : party[i]) { // 참석자
                if(knows[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) count++;
        }

		System.out.println(count);
	}
	
	public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a; // b의 parent를 a로 변경
    }

}