import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;

        int max = dp[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}