import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;

        // 2 = 2 -> 1 == dp[1] + 1
        // 2 = 2 -> 1 == dp[1] + 1

        // 3 = 3 -> 1 == dp[1] + 1
        // 3 = 3 -> 2 -> 1 == dp[2] + 1

        // 4 = 4 -> 2 -> 1 == dp[2] + 1
        // 4 = 4 -> 3 -> 2 -> 1 == dp[3] + 1

        // 5 = 5 -> 4 -> 3 -> 2 -> 1 == dp[4] + 1

        // 6 = 6 -> 3 -> 1 == dp[2] + 1
        // 6 = 6 -> 4 -> 2 -> 1 == dp[3] + 1
        // 6 = 5 -> 4 -> 3 -> 2 -> 1 == dp[5] + 1

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺀 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }


        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}