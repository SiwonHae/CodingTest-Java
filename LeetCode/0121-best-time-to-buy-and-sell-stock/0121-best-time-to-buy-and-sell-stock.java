class Solution {
    public int maxProfit(int[] prices) {
        // 가장 싼 날에 사서 가장 비싼 날에 팔자.

        int min = prices[0];
        int result = 0;

        for (int price : prices) {
            min = Math.min(price, min);
            result = Math.max(result, price - min);
        }

        return result;
    }
}