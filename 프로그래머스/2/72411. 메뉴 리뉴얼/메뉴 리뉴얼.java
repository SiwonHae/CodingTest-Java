import java.util.*;
import java.util.stream.*;

class Solution {
    static Map<String, Integer> combiMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {

        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            for (int size : course) {
                combi(0, size, orderArray, new StringBuilder());
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for (int size : course) {
            int max = 0;
            List<String> candidates = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : combiMap.entrySet()) {
                String combo = entry.getKey();
                int cnt = entry.getValue();
                
                if (combo.length() != size || cnt < 2) {
                    continue;
                }
                
                if (cnt > max) {
                    candidates.clear();
                    max = cnt;
                    candidates.add(combo);
                } else if (cnt == max) {
                    candidates.add(combo);
                }
            }
            
            for (String candidate : candidates) {
                answer.add(candidate);
            }
        }
                
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void combi(int idx, int r, char[] arr, StringBuilder sb) {
        if (sb.length() == r) {
            combiMap.put(sb.toString(), combiMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            combi(i + 1, r, arr, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}