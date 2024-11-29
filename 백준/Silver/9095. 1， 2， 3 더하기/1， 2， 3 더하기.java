import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 -> 1

        // 2 -> 2
        // 2 -> 1 + 1

        // 3 -> 3
        // 3 -> 1 + 1 + 1
        // 3 -> 1 + 2
        // 3 -> 2 + 1

        // 4 -> 1 + 1 + 1 + 1
        // 4 -> 1 + 1 + 2
        // 4 -> 1 + 2 + 1
        // 4 -> 2 + 1 + 1
        // 4 -> 2 + 2
        // 4 -> 1 + 3
        // 4 -> 3 + 1
        // dp[3] + dp[2] + dp[1]

        // 5 -> 1 + 1 + 1 + 1 + 1
        // 5 -> 1 + 1 + 1 + 2
        // 5 -> 1 + 1 + 2 + 1
        // 5 -> 1 + 2 + 1 + 1
        // 5 -> 2 + 1 + 1 + 1
        // 5 -> 1 + 2 + 2
        // 5 -> 2 + 1 + 2
        // 5 -> 2 + 2 + 1
        // 5 -> 1 + 1 + 3
        // 5 -> 1 + 3 + 1
        // 5 -> 3 + 1 + 1
        // 5 -> 2 + 3
        // 5 -> 3 + 2
        // dp[4] + dp[3] + dp[2]

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11 + 3];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
    }
}