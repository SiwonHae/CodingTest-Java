import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}