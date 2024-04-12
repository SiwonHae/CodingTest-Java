class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (price > prices[j]) {
                    break;
                }
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}