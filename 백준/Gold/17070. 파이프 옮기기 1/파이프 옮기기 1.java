import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (board[r][c] == 1) {
                    continue;
                }

                // 가로
                if (c - 1 >= 1 && board[r][c - 1] == 0) {
                    dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                }

                // 세로
                if (r - 1 >= 1 && board[r - 1][c] == 0) {
                    dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 대각선
                if (r - 1 >= 1 && c - 1 >= 1 && board[r - 1][c] == 0 && board[r][c - 1] == 0 && board[r - 1][c - 1] == 0) {
                    dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                }
            }
        }

        int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        bw.write(String.valueOf(result));
        bw.flush();
    }
}