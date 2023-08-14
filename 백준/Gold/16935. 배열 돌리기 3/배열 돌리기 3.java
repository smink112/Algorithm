import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int cal = 0;
			cal = Integer.parseInt(st.nextToken());
			
			arr = Calc(arr, cal);
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int[][] Calc(int[][] arr, int cal){
		int[][] result;
		
		int N = arr.length;
		int M = arr[0].length;
		
		switch (cal) {
		case 1:	//상하반전
			result = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					result[j][k] = arr[N-1-j][k];
				}
			}
			return result;
			
		case 2:	//좌우반전
			result = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					result[j][k] = arr[j][M-1-k];
				}
			}
			return result;
			
		case 3:	//오른쪽으로 90도 회전
			result = new int[M][N];
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					result[j][N-1-k] = arr[k][j];
				}
			}
			return result;
			
		case 4:	//왼쪽으로 90도 회전
			result = new int[M][N];
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					result[M-1-j][k] = arr[k][j];
				}
			}
			return result;
			
		case 5:	//4개의 그룹으로 나눠 1번그룹은 2번그룹으로, 2번은 3번으로, 3번은 4번으로, 4번은 1번으로 이동
			result = new int[N][M];
			for (int i = 0; i < N/2; i++) {	// 4번을 1번으로
				for (int j = 0; j < M/2; j++) {
					result[i][j] = arr[N/2+i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 1번을 2번으로
				for (int j = 0; j < M/2; j++) {
					result[i][M/2+j] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 2번을 3번으로
				for (int j = 0; j < M/2; j++) {
					result[N/2 + i][M/2 + j] = arr[i][M/2 + j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 3번을 4번으로
				for (int j = 0; j < M/2; j++) {
					result[N/2 + i][j] = arr[N/2 + i][M/2 + j];
				}
			}
			return result;
			
		case 6:	//4개의 그룹으로 나눠 1번그룹은 4번으로, 4번은 3번, 3번은 2번, 2번은 1번으로 이동
			result = new int[N][M];
			for (int i = 0; i < N/2; i++) {	// 1번을 4번으로
				for (int j = 0; j < M/2; j++) {
					result[N/2 + i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 2번을 1번으로
				for (int j = 0; j < M/2; j++) {
					result[i][j] = arr[i][M/2 + j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 3번을 2번으로
				for (int j = 0; j < M/2; j++) {
					result[i][M/2 + j] = arr[N/2 + i][M/2 + j];
				}
			}
			for (int i = 0; i < N/2; i++) {	// 4번을 3번으로
				for (int j = 0; j < M/2; j++) {
					result[N/2 + i][M/2 + j] = arr[N/2 + i][j];
				}
			}
			return result;

		default:
			break;
		}
		
		return arr;
	}
	
}
