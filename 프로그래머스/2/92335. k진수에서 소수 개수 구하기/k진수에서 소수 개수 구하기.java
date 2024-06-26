import java.util.*;

class Solution {

    public boolean isPrime(long num) {
        if (num == 1)  {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }


    public int solution(int n, int k) {
        int answer = 0;

        String number = Integer.toString(n, k);

        String[] nums = number.split("0");

        for (int i = 0; i < nums.length; i++) {

            if (nums[i].equals("")) {
                continue;
            }

            if (isPrime(Long.parseLong(nums[i]))) {
                answer++;
            }
        }

        return answer;
    }
}