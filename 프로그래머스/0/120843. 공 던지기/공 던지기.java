class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        int cnt = 0;
        int index = 0;
        while (true) {
            
            if (cnt == k) {
                break;
            }
            
            if (index == numbers.length) {
                index = 0;
            }
            
            if (index == numbers.length + 1) {
                index = 1;
            }
            
            answer = numbers[index]; 
            cnt++;
            index += 2;
        }
        
        return answer;
    }
}