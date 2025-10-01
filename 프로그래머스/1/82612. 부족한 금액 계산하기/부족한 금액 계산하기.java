class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long fee = price;
        for (int i = 0; i < count; i++) {
            answer += fee;
            fee += price;
        }
        
        if (money - answer < 0) {
            return answer - money;
        }

        return 0;
    }
}