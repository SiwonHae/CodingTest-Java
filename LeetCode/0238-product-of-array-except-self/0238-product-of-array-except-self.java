class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // [1, 2, 3, 4]에서 왼쪽에서 부터 곱해 나가면 [1, 1, 2, 6]
        // [1, 2, 3, 4]에서 오른쪽에서 부터 곱해 나가면 [24, 12, 4, 1]

        int[] result = new int[nums.length];
        int value = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = value;
            value *= nums[i];
        }

        value = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= value;
            value *= nums[i];
        }

        return result;
    }
}