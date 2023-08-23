import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());

			Node[] nodeList = new Node[N];
			for (int i = 0; i < nodeList.length; i++) {
                nodeList[i] = new Node();
            }
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = st.countTokens();
				int v = 0;
				int left = -1;
				int right = -1;
				String data = "";
				if (a == 4) {
					v = Integer.parseInt(st.nextToken());
					data = st.nextToken();
					left = Integer.parseInt(st.nextToken())-1;
					right = Integer.parseInt(st.nextToken())-1;
					nodeList[i].data = data;
					nodeList[i].left = nodeList[left];
					nodeList[i].right = nodeList[right];
				} else if (a == 3) {
					v = Integer.parseInt(st.nextToken());
					data = st.nextToken();
					left = Integer.parseInt(st.nextToken())-1;
					nodeList[i].data = data;
					nodeList[i].left = nodeList[left];
				} else if (a == 2) {
					v = Integer.parseInt(st.nextToken());
					data = st.nextToken();
					nodeList[i].data = data;
				}
				
			}
			sb.append("#").append(test_case).append(" ");
			read(nodeList[0]);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void read(Node node){
        if(node.left!=null){
            read(node.left);
        }
        sb.append(node.data);
        if(node.right!=null){
            read(node.right);
        }
    }

	static class Node {
		Node left;
		Node right;
		private String data;

		Node() {
			this.data = null;
			this.left = null;
			this.right = null;
		}

		Node(String data) {
			this.data = data;
		}

		Node(Node left, String data) {
			this.data = data;
			this.left = left;
		}

		Node(Node left, Node right, String data) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		String getData() {
			return this.data;
		}
	}
}