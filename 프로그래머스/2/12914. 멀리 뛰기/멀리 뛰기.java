class Solution {
    public long solution(int n) {
        long answer = 0;

        // 1칸 또는 2칸 뛸 수 있음.

        // n == 1 일 때 (1) => 1
        // n == 2 일 때 (1, 1) / (2) => 2
        // n == 3 일 때 (1, 1, 1) / (1, 2) / (2, 1) => 3
        // n == 4 일 때 (1, 1, 1, 1) / (1, 1, 2) / (1, 2, 1) / (2, 1, 1) / (2, 2) => 5
        // 피보나치 수열이다.

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        answer = dp[n - 1];

        return answer;
    }
}