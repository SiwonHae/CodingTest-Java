class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int cnt = 0;
                    for (int l = 1; l * l <= sum; l++) {
                        if (l * l == sum) {
                            cnt++;
                        } else if (sum % l == 0) {
                            cnt += 2;
                        }
                    }
                    if (cnt == 2) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}