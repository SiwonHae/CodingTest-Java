import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> total = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            
            int money = amount[i] * 100;
            
            while (money > 0 && !name.equals("-")) {
                total.put(name, total.getOrDefault(name, 0) + money - (money / 10));
                name = parent.get(name);
                money /= 10;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}