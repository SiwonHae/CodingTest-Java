import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean flag = true;
            for (String name : want) {
                if (wantMap.get(name) > discountMap.getOrDefault(name, 0)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}