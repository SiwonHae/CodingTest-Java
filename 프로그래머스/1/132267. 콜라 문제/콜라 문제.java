class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int get = (n / a) * b;
            int current = n % a;
            
            answer += get;
            n = get + current;
        }
        
        return answer;
    }
}