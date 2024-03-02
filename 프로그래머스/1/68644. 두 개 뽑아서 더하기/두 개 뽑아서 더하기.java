import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = 0;
                sum += numbers[i] + numbers[j];
                if (!num.contains(sum)) {
                    num.add(sum);
                }
            }
        }

        int listSize = num.size();
        int[] answer = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            answer[i] = num.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}