import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
arr(퀸 배치 정보 저장 배열)
N(체스판 크기 N*N)
count 퀸을 배치하는 경우의 수 저장 변수

백트래킹 실행 (매개변수 : 행)
경우의 수 출력

backtrcking(현재행) {
    if( 퀸 N개를 모두 배치한 경우)
        경우의 수 1 증가 및 함수 반환
    for (1~N까지 모든 열 탐색)
        i열에 퀸 배치하기
        if( 이번 행에 배치한 퀸이 이전 퀸들과 공격할 수 없는 경우){
            행의 값을 1 증가시키고 backtracking 함수 재귀호출
        }
}

// 공격 불가능 여부 체크 함수 상세 구현하기
check(현재 행) {
    for (0행부터 현재 행 전까지 배치된 모든 퀸 탐색) {
        if (이번에 배치한 퀸과 세로 배치가 있는경우) 공격 가능 반환
        if (이번에 배치한 퀸과 대각선 배치가 있는 경우) 공격 가능 반환
    }
    공격 불가능 반환
}
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        backtracking(0);

        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[row] = i; // 열에 퀸을 배치 해보기
            if (check(row)) {    // 가지치기 유효성 검사
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row]) return false;
            if (Math.abs(i - row) == Math.abs(arr[i] - arr[row])) return false;
        }
        return true;
    }
}
