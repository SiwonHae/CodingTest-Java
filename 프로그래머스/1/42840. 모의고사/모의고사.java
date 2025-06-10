import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int oneIdx = i % one.length;
            int twoIdx = i % two.length;
            int threeIdx = i % three.length;
            
            int answer = answers[i];
            
            if (answer == one[oneIdx]) {
                oneCnt++;
            } 
            if (answer == two[twoIdx]) {
                twoCnt++;
            }
            if (answer == three[threeIdx]) {
                threeCnt++;
            }
        }
        
        int max = oneCnt;
        list.add(1);
        
        if (max <= twoCnt) {
            if (max == twoCnt) {
                list.add(2);
            } else {
                max = twoCnt;
                list.remove(0);
                list.add(2);
            }
        } 
        if (max <= threeCnt) {
            if (max == threeCnt) {
                list.add(3);
            } else {
                max = threeCnt;
                list.clear();
                list.add(3);
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}