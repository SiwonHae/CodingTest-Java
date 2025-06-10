import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        
        int people = stages.length;
        
        for (int i = 1; i <= N; i++) {
            int failPeople = 0;
            
            for (int j = 0; j < stages.length; j++) {        
                if (i == stages[j]) {
                    failPeople++;
                }
            }

            map.put(i, (people == 0) ? 0.0 : (double) failPeople / people);
            people -= failPeople;
        }
        
        return map.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}