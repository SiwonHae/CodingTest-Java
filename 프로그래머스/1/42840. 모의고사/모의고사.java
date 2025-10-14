import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if (one[i % one.length] == answer) {
                sum1++;
            }
            if (two[i % two.length] == answer) {
                sum2++;
            }
            if (three[i % three.length] == answer) {
                sum3++;
            }
        }
        
        int max = Math.max(sum1, Math.max(sum2, sum3));

        List<Integer> list = new ArrayList<>();
        if (sum1 == max) {
            list.add(1);
        }
        if (sum2 == max) {
            list.add(2);
        }
        if (sum3 == max) {
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}