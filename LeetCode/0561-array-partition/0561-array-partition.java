class Solution {
    public int arrayPairSum(int[] nums) {
        // nums 개를 절반으로 나눈 값 만큼의 pair가 발생하게 된다.
        // 이 pair의 최대합 구하자.

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }
}