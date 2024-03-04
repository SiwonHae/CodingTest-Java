import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // N/2 개 선택.
        int select = nums.length / 2;

        List<Integer> cnt = new ArrayList<>(); // 종류 번호의 개수
        for (int i = 0; i < nums.length; i++) {
            if (!cnt.contains(nums[i])) {
                cnt.add(nums[i]);
            }
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