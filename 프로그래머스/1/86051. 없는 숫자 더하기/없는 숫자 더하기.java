class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] arr = new int[10];
        for (int x : numbers) {
            arr[x]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}