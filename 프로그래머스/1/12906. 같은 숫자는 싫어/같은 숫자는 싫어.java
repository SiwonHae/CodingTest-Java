import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> ans = new ArrayList<>();

        int num = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != num) {
                ans.add(arr[i]);
                num = arr[i];
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}