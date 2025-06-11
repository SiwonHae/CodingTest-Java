import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int time = 1;
            
            for (int j = i + 1; j < prices.length - 1; j++) {
                if (price <= prices[j]) {
                    time++;
                } else {
                    break;
                }
            }
            
            answer[i] = time;
        }
        
        answer[prices.length - 1] = 0;
        
        return answer;
    }
}