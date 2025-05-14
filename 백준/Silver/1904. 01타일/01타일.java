import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 또는 00 으로만 이어 붙일 수 있다.
        // N = 3, 100, 001, 111

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}