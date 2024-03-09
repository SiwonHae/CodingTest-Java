import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        StringBuilder answer = new StringBuilder();

        int[] xCnt = new int[10];
        int[] yCnt = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xCnt[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yCnt[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
        }

        for (int i = 9; i >= 0; i--) {
            while (xCnt[i] > 0 && yCnt[i] > 0) {
                answer.append(i);

                xCnt[i]--;
                yCnt[i]--;
            }
        }

        if (answer.toString().equals("")) {
            answer = new StringBuilder("-1");
        } else if (answer.charAt(0) == '0') {
            answer = new StringBuilder("0");
        }

        return answer.toString();
    }
}