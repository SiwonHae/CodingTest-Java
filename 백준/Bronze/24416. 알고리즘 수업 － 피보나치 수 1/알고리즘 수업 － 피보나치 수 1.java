import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt1;
    static int cnt2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        bw.write(cnt1 + " " + cnt2);
        bw.flush();
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}