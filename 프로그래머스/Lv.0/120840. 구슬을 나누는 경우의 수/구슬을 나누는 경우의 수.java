class Solution {
    public int solution(int balls, int share) {

        int answer = 0;

        answer = combi(balls, share);
        
        return answer;
    }
    
    public int combi(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }
        return combi(n - 1, m) + combi(n - 1, m - 1);
    }
}