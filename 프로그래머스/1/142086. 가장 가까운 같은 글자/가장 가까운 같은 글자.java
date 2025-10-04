import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (chars[c - 'a'] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - chars[c - 'a'];
            }
            chars[c - 'a'] = i;
        }
        
        return answer;
    }
}