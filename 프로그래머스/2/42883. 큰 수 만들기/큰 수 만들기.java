import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int length = number.length() - k;
        String[] splitNum = number.split("");
        int[] num = new int[splitNum.length];
        for (int i = 0; i < splitNum.length; i++) {
            num[i] = Integer.parseInt(splitNum[i]);
        }
        
        StringBuilder sb = new StringBuilder();

        int max = 0;
        int idx = 0;
        for (int i = 0; i < length; i++) {
            max = 0;
            for (int j = idx; j <= i + k; j++) {
                if (num[j] > max) {
                    max = num[j];
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        
        answer = sb.toString();

        return answer;
    }
}