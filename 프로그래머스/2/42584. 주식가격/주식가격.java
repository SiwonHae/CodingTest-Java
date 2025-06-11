import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>(); // 배열의 인덱스를 저장하는 스택
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}