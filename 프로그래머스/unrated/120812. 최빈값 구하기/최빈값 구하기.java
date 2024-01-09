import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;

        int[] arrayNum = new int[1000];
        
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            arrayNum[array[i]]++;
            
            if (max < arrayNum[array[i]]) {
                max = arrayNum[array[i]];
                answer = array[i];
            }
        }
        
        int freq = 0;
        for (int i = 0; i < arrayNum.length; i++) {
            if (max == arrayNum[i]) {
                freq++;
            }
            
            if (freq > 1) {
                answer = -1;
            }
        }

        return answer;
    }
}