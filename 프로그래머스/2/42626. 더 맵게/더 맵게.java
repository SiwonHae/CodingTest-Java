import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        
        if (pq.peek() >= K) {
            return answer;
        }
        
        while (pq.size() >= 2) {
            int mix = pq.poll() + (pq.poll() * 2);
            pq.offer(mix);
            answer++;
            
            if (pq.peek() >= K) {
                return answer;
            }
        }
        
        return -1;
    }
}