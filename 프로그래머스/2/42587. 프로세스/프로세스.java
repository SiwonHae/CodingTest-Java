import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int run = 0;
        
        for (int i : priorities) {
            pq.offer(i);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                int current = priorities[i];
                
                if (current == pq.peek()) {
                    pq.poll();
                    answer++;
                    
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}