import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M][3];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }

        for (int j=0; j < M; j++) {
            dp[0][j][0] = board[0][j];
            dp[0][j][1] = board[0][j];
            dp[0][j][2] = board[0][j];
        }

        // 같은 방향으로 동시에 두 번 이동할 수 없음
        for (int i=1; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + board[i][j];
                }

                else if (j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + board[i][j];
                    dp[i][j][1] = dp[i-1][j][2] + board[i][j];
                }

                else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j];
                }
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        int minValue = (int) 1e9;

        for (int j=0; j < M; j++) {
            for (int k=0; k < 3; k++) {
                minValue = Math.min(minValue, dp[N-1][j][k]);
            }
        }

        System.out.println(minValue);
    }
}
