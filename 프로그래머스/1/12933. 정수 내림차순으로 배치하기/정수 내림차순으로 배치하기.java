class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int[] nums = new int[10];
        
        while (n > 0) {
            nums[(int)(n % 10)]++;
            n /= 10;
        }
        
        for (int i = 9; i >= 0; i --) {
            while (nums[i] > 0) {
                answer = answer * 10 + i;
                nums[i]--;
            }
        }
        
        return answer;
    }
}