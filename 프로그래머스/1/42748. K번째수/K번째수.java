import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            int c = commands[i][2] - 1;
            
            List<Integer> temp = new ArrayList<>();
            
            for (int j = a; j < b; j++) {
                temp.add(array[j]);
            }
            Collections.sort(temp);
            
            answer[i] = temp.get(c);
        }
        
        return answer;
    }
}