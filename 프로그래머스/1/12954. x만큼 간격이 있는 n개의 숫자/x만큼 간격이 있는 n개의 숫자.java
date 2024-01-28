class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long index = x;
        for (int i = 0; i < n; i++) {
            answer[i] = index;
            index += x;
        }
        
        return answer;
    }
}