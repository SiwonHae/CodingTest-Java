import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        double[] diffList = new double[numlist.length];

        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] - n < 0) {
                // n 보다 작은 수면 + 0.5를 함.
                diffList[i] = Math.abs(numlist[i] - n) + 0.5;
            } else {
                diffList[i] = numlist[i] - n;
            }
        }
        Arrays.sort(diffList);

        for (int i = 0; i < numlist.length; i++) {
            if (diffList[i] % 1 != 0) {
                // 1로 나눠서 0이 아니면 실수임.
                // int로 형 변환하면 소수점은 버려짐.
                answer[i] = n - (int)diffList[i];
            } else {
                answer[i] = (int)diffList[i] + n;
            }
        }

        return answer;
    }
}