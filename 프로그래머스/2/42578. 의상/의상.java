import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        for (String kind : map.keySet()) {
            answer *= (map.get(kind) + 1);
        }
        
        answer--;
        
        return answer;
    }
}