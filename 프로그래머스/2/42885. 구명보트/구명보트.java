import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 한번에 최대 2명만 탈 수 있고 무게 제한 limit

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }

        return answer;
    }
}