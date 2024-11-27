import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1; // 1^2
        // 4 = 2^2
        // 5 = 2^2 + 1^2
        // 6 = 2^2 + 1^2 + 1^2
        // 7 = 2^2 + 1^2 + 1^2 + 1^2
        // 8 = 2^2 + 2^2
        // 9 = 3^2

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}