import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String number = String.valueOf(n);

        char[] num = number.toCharArray();
        for (int i = 0; i < num.length; i++) {
            answer += num[i] - '0';
        }

        return answer;
    }
}