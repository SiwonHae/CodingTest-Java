import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // N/2 개 선택.
        int select = nums.length / 2;

        HashSet<Integer> cnt = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            cnt.add(nums[i]);
        }
        int size = cnt.size();

        if (size <= select) {
            answer = size;
        } else {
            answer = select;
        }

        return answer;
    }
}
