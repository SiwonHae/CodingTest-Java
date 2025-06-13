import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        
        for (String word : cards1) {
            queue1.offer(word);
        }
        
        for (String word : cards2) {
            queue2.offer(word);
        }
        
        for (String target : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(target)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(target)) {
                queue2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}