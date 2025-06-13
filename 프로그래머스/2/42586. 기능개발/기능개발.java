import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int remain = 100 - progress;
            
            queue.offer(remain % speed == 0 ? remain / speed : remain / speed + 1);
        }
        
        int current = queue.poll();
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int next = queue.poll();
            
            if (current < next) {
                list.add(cnt);
                current = next;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        list.add(cnt);
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}