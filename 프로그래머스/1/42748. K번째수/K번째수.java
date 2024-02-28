import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];

            int[] result = new int[end - start + 1];
            int index = 0;
            for (int j = start - 1; j < end; j++) {
                result[index] = array[j];
                index++;
            }
            Arrays.sort(result);
            answer[i] = result[target - 1];
        }

        return answer;
    }
}