import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        int[] ans = new int[2];
        int sub = Integer.MAX_VALUE;
        while (end - start > 0) {
            if (arr[end] + arr[start] == 0) {
                ans[0] = arr[start];
                ans[1] = arr[end];
                break;
            }

            if (Math.abs(arr[end] + arr[start]) < sub) {
                sub = Math.abs(arr[end] + arr[start]);
                ans[0] = arr[start];
                ans[1] = arr[end];
            }

            //start랑 end 다음껄로 넘겨주는작업!
            if(arr[end] + arr[start] > 0){
                end--;
            }else {
                start++;
            }


        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}