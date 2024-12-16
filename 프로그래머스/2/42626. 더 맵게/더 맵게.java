import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) {
            pq.offer(i);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            
            int mix = a + b * 2;
            pq.offer(mix);
            
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}