import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int sumOne = 0;
        int sumTwo = 0;
        int sumThree = 0;
        int indexOne = 0;
        int indexTwo = 0;
        int indexThree = 0;

        for (int i = 0; i < answers.length; i++) {
            if (i % one.length == 0) {
                indexOne = 0;
            }
            if (i % two.length == 0) {
                indexTwo = 0;
            }
            if (i % three.length == 0) {
                indexThree = 0;
            }

            if (answers[i] == one[indexOne]) {
                sumOne++;
            }
            if (answers[i] == two[indexTwo]) {
                sumTwo++;
            }
            if (answers[i] == three[indexThree]) {
                sumThree++;
            }

            indexOne++;
            indexTwo++;
            indexThree++;
        }

        List<Integer> result = new ArrayList<>();
        result.add(sumOne);
        result.add(sumTwo);
        result.add(sumThree);
        int max = Collections.max(result);
        int cnt = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == max) {
                cnt++;
            }
        }

        int[] answer = new int[cnt];
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == max) {
                answer[index] = i + 1;
                index++;
            }
        }

        return answer;
    }
}