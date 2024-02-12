class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long total = 0;
        long current = price;
        for (int i = 0; i < count; i++) {
            total += current;
            current += price;
        }

        answer = total - money;
        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }
}