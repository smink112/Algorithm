import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        long count = 0;

        int[][] arr = new int[N][3];    //0 : a, 1 : b, 2: abs(a-b)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = Math.abs(a-b);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }

        for (int i = 0; i < N; i++) {
            if(Math.min(arr[i][0], arr[i][1]) == arr[i][0]){
                if(A>0){
                    A--;
                    count += arr[i][0];
                }else{
                    B--;
                    count += arr[i][1];
                }
            }else{
                if(B>0){
                    B--;
                    count += arr[i][1];
                }else {
                    A--;
                    count += arr[i][0];
                }
            }
        }

        System.out.print(count);
    }
}