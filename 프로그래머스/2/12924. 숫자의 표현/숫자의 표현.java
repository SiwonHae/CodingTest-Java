class Solution {
    public int solution(int n) {
        int answer = 0;

        int sum = 0;
        int idx = 1;
        int start = 2;

        while (start != n) {
            
            if (n == 1) {
                break;
            }
            
            if (sum == n) {
                sum = 0;
                answer++;
                idx = start;
                start++;
            } else if (sum > n) {
                sum = 0;
                idx = start;
                start++;
            }
            sum += idx;
            idx++;
        }
        
        answer++; // 자기 자신인 경우

        return answer;
    }
}