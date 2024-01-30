import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String s = String.valueOf(n);

        long[] num = new long[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num[i] = c - '0';
        }

        for (int i = 0; i < s.length() - 1; i++){
            for (int j = 0; j < s.length() - 1; j++) {
                if (num[j] < num[j + 1]) {
                    long temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                }
            }
        }

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            ans += num[i];
        }
        answer = Long.parseLong(ans);

        return answer;
    }
}