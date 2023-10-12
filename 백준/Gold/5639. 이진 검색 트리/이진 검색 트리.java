import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Node root  = new Node(Integer.parseInt(sc.nextLine()));

        String str;
        while (sc.hasNextLine()){
            str = sc.nextLine();

            root.add(Integer.parseInt(str));
        }

        postorder(root);

        System.out.println(sb);
    }

    static class Node{
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }

        public void add(int n){
            if(n < this.v)
            {
                if(this.left==null)
                    this.left=new Node(n);
                else this.left.add(n);
            }
            else
            {
                if(this.right==null)
                    this.right=new Node(n);
                else this.right.add(n);
            }
        }
    }

    public static void postorder(Node node){
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.v).append('\n');
    }
}