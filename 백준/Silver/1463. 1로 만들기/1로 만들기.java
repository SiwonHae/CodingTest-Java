import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1 빼기

            if (i % 2 == 0) { // 2로 나누기
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) { // 3으로 나누기
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}