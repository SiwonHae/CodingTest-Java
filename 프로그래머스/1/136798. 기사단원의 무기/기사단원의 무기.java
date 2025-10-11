class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 약수의 개수가 limit을 넘으면 power의 공격력을 가진다.
        for (int knight = 1; knight <= number; knight++) {
            int n = solve(knight);
            
            if (n > limit) {
                answer += power;
            } else {
                answer += n;
            }
        }
        
        return answer;
    }
    
    public int solve(int n) {
        int sum = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                sum++;
            } else if (n % i == 0) {
                sum += 2;
            }
        }
        
        return sum;
    }
}