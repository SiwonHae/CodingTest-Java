import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 작업까지 남은 일수를 저장하자.
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
            int remainProgress = 100 - progresses[i];
            if (remainProgress % speeds[i] != 0) {
                day = remainProgress / speeds[i] + 1;
            } else {
                day = remainProgress / speeds[i];
            }
            queue.offer(day);
        }
        
        List<Integer> deployList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int deploy = 1;
            
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                deploy++;
            }
            
            deployList.add(deploy);
        }
        
        int[] answer = new int[deployList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deployList.get(i);
        }
        
        return answer;
    }
}