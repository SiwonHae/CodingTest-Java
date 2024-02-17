import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int index = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) {
                index = i;
                break;
            } else if (sum == budget) {
                index = i + 1;
                break;
            } else if (i == d.length - 1) {
                index = d.length;
                break;
            }
        }

        answer = index;

        return answer;
    }
}